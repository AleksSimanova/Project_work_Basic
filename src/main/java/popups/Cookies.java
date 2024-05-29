package popups;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cookies extends AbsPopus {
    public Cookies(WebDriver driver) {
        super(driver);
    }

    protected String cookiesButtonCss = "button.cookies__button";

    public void cooliesClick(){

        assertThat(waiters.waitFroElementVisibole(By.cssSelector(cookiesButtonCss))).as("cookies are not offered") ;
        //waiters.waitForCondition(ExpectedConditions.elementToBeClickable((By.cssSelector(cookiesButtonCss)));
        $(By.cssSelector(cookiesButtonCss)).click();
        assertThat( waiters.waitFroElementInvisibole(By.cssSelector(cookiesButtonCss))).as("cookies are not accepted");


    }
}
