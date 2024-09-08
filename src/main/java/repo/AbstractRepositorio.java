package repo;

import org.intellij.lang.annotations.Language;
import model.Cargable;
import model.Repositorio;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractRepositorio<T extends Cargable> implements Repositorio<T> {

    protected List<T> list = new LinkedList<>();

    public AbstractRepositorio() {
        loadAll();
    }

    @Override
    public List<T> getAll() {
        return list;
    }

    public abstract Class<T> getEntityClass();

    public T add(T t) {
        list.add(t);
        return t;
    }

    @Override
    public void loadRow(ResultSet rs) throws SQLException {
        T t = createInstance();
        t.loadRow(rs);
        add(t);
    }

    public T createInstance() {
        try {
            return getEntityClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAll() {
        @Language("postgresql")
        String query = "SELECT * FROM " + getTableName() + ";";
        SQLManager.executeQuery(query).thenAccept(rs -> {
            try {
                while (rs.next()) {
                    loadRow(rs);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }).exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        }).join();
    }
}