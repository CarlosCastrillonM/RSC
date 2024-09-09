import org.junit.jupiter.api.Test;
import datos.Oferta;
import repo.Repositorios;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class SaveTest {
    @Test
    public void saveAdmins() {
        Repositorios.OFERTAS.crearOferta("Coche", "Nissan", 3, LocalDate.of(2003, 1, 5), LocalTime.now(), "Santa Marta").join();
        Repositorios.OFERTAS.crearOferta("Nave", "Onix", 4, LocalDate.of(2003, 12, 15), LocalTime.now(), "Bucaramanga").join();

    }
}