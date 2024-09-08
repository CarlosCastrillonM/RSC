package model;

import repo.SQLManager;

public interface Cargador<T> {
    String getTableName();

    T load(int id);

    default <G extends Guardable> void save(G t) {
        t.save();
    }
}