import java.sql.*;
import java.util.Properties;

import org.rsc.Main;

public class RSC {

    private static final String GCP_URL = "35.199.121.103";
    private static final String GCP_USER = "proyectopoo";
    private static final String GCP_PASS = "alksjhdasdlkj";

    public static void main(String[] args) throws SQLException {
        Main.main(args);
        if (true) {
            return;
        }

        String url = "jdbc:postgresql://%s:5432/postgres".formatted(GCP_URL);
        Properties props = new Properties();
        props.setProperty("user", GCP_USER);
        props.setProperty("password", GCP_PASS);
        props.setProperty("ssl", "false");
        Connection conn = DriverManager.getConnection(url, props);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT 1");
        rs.next();
        rs.close();
//
//        while (rs.next()) {
//            System.out.print("Column 1 returned ");
//            System.out.println(rs.getString(3));
//        }
//        rs.close();
//        st.close();
        conn.close();
    }
}
