import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.grid.selenium.GridLauncherV3;
import reporter.Reporter;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        glue = "steps")
public class CucumberRunner {

    private static final String URL = "http://10.11.13.120:4444";
    private static final String REGISTER = "/grid/register/";

    @BeforeClass
    public static void setup() {
        if (System.getProperty("platform").equals("grid")) {
            GridLauncherV3.main(new String[]{"-port", "4444"});
            WebDriverManager.chromedriver().setup();
            GridLauncherV3.main(new String[]{"-role", "node", "-hub",
                    URL + REGISTER, "-browser",
                    "browserName=chrome", "-port", "5555"});
            GridLauncherV3.main(new String[]{"-role", "node", "-hub",
                    URL + REGISTER, "-browser",
                    "browserName=chrome", "-port", "5556"});
        }
    }

    @AfterClass
    public static void teardown() {
        if (System.getProperty("platform").equals("grid")) {
            try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
                client.execute(new HttpGet(URL + "/lifecycle-manager/LifecycleServlet?action=shutdown"));
                Reporter.info("Shutdown grid hub");
            } catch (IOException err) {
                Reporter.error("Cannot send request for grid shutdown");
            }
        }
    }
}
