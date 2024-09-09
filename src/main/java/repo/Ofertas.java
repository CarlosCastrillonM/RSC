package repo;

import datos.Oferta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class Ofertas extends AbstractRepositorio<Oferta> {
    @Override
    public String getTableName() {
        return "oferta";
    }

    @Override
    public Class<Oferta> getEntityClass() {
        return Oferta.class;
    }

    public CompletableFuture<Oferta> crearOferta(String tipo_transporte, String marca, int capacidad, LocalDate fecha, LocalTime horario, String destino) {
        return SQLManager.executeQuery("""
                INSERT INTO oferta (tipo_transporte, marca, capacidad, fecha, horario, destino)
                VALUES (?, ?, ?, ?, ?, ?) RETURNING id""", tipo_transporte, marca, capacidad, fecha, horario, destino)
                .thenApply(id -> {
                    try {
                        id.next();
                        return new Oferta(id.getInt(1), tipo_transporte, marca, capacidad, fecha, horario, destino);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}