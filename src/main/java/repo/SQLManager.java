package repo;

import org.intellij.lang.annotations.Language;
import util.SafeFunction;

import java.util.Date;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class SQLManager {
    @Language("postgresql")
    private static final String CREATE_TABLE_TRANSPORTE = """
    CREATE TABLE IF NOT EXISTS transporte (
        id SERIAL PRIMARY KEY,          -- Identificador único con auto-incremento
        tipo_transporte VARCHAR(50) NOT NULL, -- Tipo de transporte, tamaño ajustable según necesidades
        marca VARCHAR(50) NOT NULL,     -- Marca del transporte
        capacidad INT NOT NULL,         -- Capacidad en número entero
        fecha DATE NOT NULL,            -- Fecha en formato de fecha estándar
        horario TIME NOT NULL,          -- Horario en formato de tiempo estándar
        destino VARCHAR(100) NOT NULL   -- Destino del transporte, tamaño ajustable
    );
    """;

    private static final String GCP_URL = "35.199.121.103";
    private static final String GCP_USER = "proyectopoo";
    private static final String GCP_PASS = "alksjhdasdlkj";
    private static final Connection conn;

    static {
        String url = "jdbc:postgresql://%s:5432/postgres".formatted(GCP_URL);
        Properties props = new Properties();
        props.setProperty("user", GCP_USER);
        props.setProperty("password", GCP_PASS);
        props.setProperty("ssl", "false");
        try {
            conn = DriverManager.getConnection(url, props);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT 1");
            rs.next();
            rs.close();

            createTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTables() {
        try {
            Statement st = conn.createStatement();
//            st.execute(CREATE_TABLE_APTITUDES);
//            st.execute(CREATE_TABLE_CUENTA);
//            st.execute(CREATE_TABLE_);
//            st.execute(CREATE_TABLE_A);
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<ResultSet> executeQuery(@Language("postgresql") String query,  Object... params) {
        CompletableFuture<ResultSet> cf = new CompletableFuture<>();
        executeOperation(query, params, preparedStatement -> {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                cf.complete(rs);
            } catch (Throwable e) {
//                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return null;
        });
        return cf;
    }

    public static CompletableFuture<Integer> executeUpdate(@Language("postgresql") String query,  Object... params) {
        return executeOperation(query, params, PreparedStatement::executeUpdate);
    }

    public static PreparedStatement createStatement(@Language("postgresql") String query,  Object... params) throws SQLException {
        System.out.println(query);
        PreparedStatement st = conn.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            Object obj = params[i];
            if (obj instanceof java.util.Date date) {
                System.out.println(date);
                st.setDate(i + 1, new java.sql.Date(date.toInstant().toEpochMilli()));
                continue;
            }

            st.setObject(i + 1, obj);
        }
        return st;
    }

    private static synchronized <T> CompletableFuture<T> executeOperation(@Language("postgresql") String query, Object[] params, SafeFunction<PreparedStatement, T> supplier) {
        AtomicReference<PreparedStatement> at = new AtomicReference<>();
        return CompletableFuture.supplyAsync(() -> {
            try {
                PreparedStatement ps = createStatement(query, params);
                at.set(ps);

                return supplier.applySafe(ps);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }).whenComplete((t, e) -> {
            if (e != null) {
                e.printStackTrace();
            }

            PreparedStatement ps = at.get();
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}