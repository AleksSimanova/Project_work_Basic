package factory;

import exceptions.DriverNotSupportedException;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    WebDriver create() throws DriverNotSupportedException;
}
