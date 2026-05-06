// ======================================================================
//  LEGACY TEST – MAL HECHO
// ======================================================================

import org.junit.jupiter.api.Test;

public class MalTaskControllerTest {

    @Test
    public void testLegacyProcess() {

        MalTaskController controller = new MalTaskController();

        // SMELL controller with too many parameters
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
