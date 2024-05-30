package pages;

import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public abstract class AbsPageBase extends AbsPageObject {

    private final static String BASE_URL = System.getProperty("base.url").endsWith("/")
            ? System.getProperty("base.url").substring(0, System.getProperty("base.url").length() - 1)
            : System.getProperty("base.url");
    private String path = "";

    public AbsPageBase(WebDriver driver, String path) {
        super(driver);
        this.path = path.startsWith("/") ? path : "/" + path;
    }

    public AbsPageBase(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + path);
    }
}

