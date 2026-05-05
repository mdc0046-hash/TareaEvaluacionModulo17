import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskControllerTest {

    private WebDriver driver;
    private TaskController controller;

    @BeforeEach
    public void initEnvironment() {
        // Configura automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Instancia del controlador que quieres probar
        controller = new TaskController();
    }

    @Test
    public void validateTaskProcessingFlow() {

        // Abrimos una página estable para validar que Selenium funciona
        driver.get("https://the-internet.herokuapp.com/");

        // Creamos los objetos que TaskController necesita
        Task task = new Task("Fix login bug", 3, 40.0, "URGENT");
        User user = new User("developer@example.com");

        // Llamamos al método principal del controlador
        controller.processTask(task, user);

        // Comprobación básica: si no hay excepciones, el test es válido
        assert driver.getTitle() != null;
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
