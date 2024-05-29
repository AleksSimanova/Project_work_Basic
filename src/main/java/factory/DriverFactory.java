package factory;

import java.util.Locale;

import factory.impl.ChromeSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import factory.impl.FirefoxSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import exceptions.DriverNotSupportedException;

public class DriverFactory implements IDriverFactory{
    private String browserType= System.getProperty("browser.name","CHROME");

    BrouserNameData brouserNameData = BrouserNameData.valueOf(browserType.toUpperCase(Locale.ROOT));
    @Override
    public WebDriver create() throws DriverNotSupportedException{
        switch (this.browserType) {
            case "CHROME":{
                WebDriverManager.chromedriver().setup();
//                return new ChromeDriver();
                return new ChromeDriver((ChromeOptions)new ChromeSettings().settings());

            }
            case "FIREFOX":{
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) new FirefoxSettings().settings());
            }
            case "SAFARI":{
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            default: {
                throw new DriverNotSupportedException(this.browserType);
            }
        }
    }
}
