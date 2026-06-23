package hooks;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import base.Base;

public class ScenarioHook extends Base {

    @Before
    public void setup() {
        try {
            String browser = this.getBrowser();
            System.out.println("java -jar src/main/resources/selenium-server-4.44.0.jar standalone");
            
            RemoteWebDriver activeDriver = null;

            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setCapability("platformName", "Windows");
                activeDriver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                options.setCapability("platformName", "Windows");
                activeDriver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
            }


            if (activeDriver != null) {
                setDriver(activeDriver);
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } else {
                System.out.println("Initialization failed: Invalid or missing browser properties.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
  
        if (getDriver() != null) {
            try {
                if (!scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                    Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
                    Thread.sleep(5000);
                }
            } finally {
            	Thread.sleep(2000);
                getDriver().quit();
            }
        }
    }
}