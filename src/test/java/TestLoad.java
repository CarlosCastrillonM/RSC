import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import datos.Oferta;
import repo.Repositorios;

public class TestLoad {
    int initialId = 0;

    @Test
    public void testLoadOfertas() {
        System.out.println("TestLoad.testLoadOfertas");
        Repositorios.OFERTAS.getAll().forEach(System.out::println);
    }
}
