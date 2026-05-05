// ======================================================================
//  LEGACY TEST – MAL HECHO
//  (Este es el archivo que mostrarás como "ANTES")
// ======================================================================

import org.junit.jupiter.api.Test;

public class MalTaskControllerTest {

    @Test
    public void testLegacyProcess() {

        MalTaskController controller = new MalTaskController();

        // SMELL – demasiados parámetros, sin objetos
        controller.processTask(
                "Fix bug",
                3,
                40.0,
                "URGENT",
                "developer@example.com",
                "Old Street",
                "123456"
        );

        assert true;
    }
}
