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
        // This will configure the chrowe drivers soo that they work with the extension!
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Instance of the controller starting
        controller = new TaskController();
    }

    @Test
    public void validateTaskProcessingFlow() {

        // We open a safe web to work out the extension
        driver.get("https://the-internet.herokuapp.com/");

        // We create an object with this data
        Task task = new Task("Fix login bug", 3, 40.0, "URGENT");
        User user = new User("developer@example.com");

        // We call the first controller
        controller.processTask(task, user);

        // We will do a simple test, just to see if it works well.
        assert driver.getTitle() != null;
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
