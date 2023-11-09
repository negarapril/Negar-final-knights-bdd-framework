package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.BinaryOperator;

public class BaseSetup {


    private static WebDriver driver;

    public void openBrowser() {

        String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/dev_env_config.properties";


        Properties properties = new Properties();


        try {
            FileInputStream configFile = new FileInputStream(configFilePath);
            properties.load(configFile);

        } catch (IOException e) {
            e.printStackTrace();
        }


        String baseUrl = properties.getProperty("ui.url");
        String browserType = properties.getProperty("ui.browser.type");


        if (browserType.equalsIgnoreCase("chrome")) {
            // Add headless option to Chrome browser
            //ChromeOptions options = new ChromeOptions();
            //  options.addArguments("--headless");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Wrong Browser Type");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void driverQuit() {
        if (driver != null) driver.quit();
    }


    public WebDriver getDriver() {
        return driver;
    }

}
