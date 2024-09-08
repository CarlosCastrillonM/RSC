package model;

import repo.SQLManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T extends Cargable> {
    String getTableName();

    List<T> getAll();

    default T get(int id) {
        return getAll().stream()
                .filter(t -> t.getId() == id)
                .findFirst().orElse(null);
    }

    void loadRow(ResultSet rs) throws SQLException;

    void loadAll();
}