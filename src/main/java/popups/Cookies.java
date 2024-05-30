package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Cookies extends AbsPopus {
    public Cookies(WebDriver driver) {
        super(driver);
    }

    protected String cookiesButtonCss = "button.cookies__button";

    public void cooliesClick() {
        assertThat(waiters.waitFroElementVisibole(By.cssSelector(cookiesButtonCss))).as("cookies are not offered");
        $(By.cssSelector(cookiesButtonCss)).click();
        assertThat(waiters.waitFroElementInvisibole(By.cssSelector(cookiesButtonCss))).as("cookies are not accepted");
    }
}
