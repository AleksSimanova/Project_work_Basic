package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private WebDriver driver;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(condition);
            return true;
        } catch (TimeoutException ignore) {
            return false;
        }
    }

    public boolean waitFroElementVisibole(By locator) {
        return this.waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitFroElementInvisibole(By locator) {
        return this.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
