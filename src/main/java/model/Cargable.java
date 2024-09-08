package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Cargable {
    /**
     * Obtiene el identificador de la entidad. En la base de datos
     *
     * @return El identificador de la entidad.
     */
    int getId();

    /**
     * Carga los datos de la entidad desde un ResultSet.
     *
     * @param rs El ResultSet con los datos de la entidad.
     */
    void loadRow(ResultSet rs) throws SQLException;
}
