package model;

/**
 * Interfaz que indica que una clase es persistente.
 */
public interface Guardable extends Cargable {

    /**
     * Guarda la entidad en la base de datos.
     */
    void save();
}