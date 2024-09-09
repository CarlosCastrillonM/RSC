package datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Guardable;
import repo.SQLManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class Oferta implements Guardable {

    private int id;
    private String tipo_transporte;
    private String marca;
    private int capacidad;
    private LocalDate fecha;
    private LocalTime horario;
    private String destino;

    public Oferta(int id, String tipo_transporte, String marca, int capacidad, LocalDate fecha, LocalTime horario, String destino) {
        this.id = id;
        this.tipo_transporte = tipo_transporte;
        this.marca = marca;
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.horario = horario;
        this.destino = destino;
//        this.aptitudes = aptitudes;
    }

    public Oferta() {
    }

    public int getId() {
        return id;
    }

    @Override
    public void loadRow(ResultSet rs) throws SQLException {
        id = rs.getInt("id");
        tipo_transporte = rs.getString("tipo_transporte");
        marca = rs.getString("marca");
        capacidad = rs.getInt("capacidad");
        fecha = LocalDate.parse(rs.getString("fecha"));
        horario = LocalTime.parse(rs.getString("horario"));
        destino = rs.getString("destino");
    }

    public String getTipoTransporte() {
        return tipo_transporte;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public void save() {
        SQLManager.executeUpdate("""
            UPDATE oferta SET
                tipo_transporte = ?,
                marca = ?,
                capacidad = ?,
                fecha = ?,
                horario = ?,
                destino = ?
            WHERE id = ?
            """, tipo_transporte, marca, id);
    }
}
