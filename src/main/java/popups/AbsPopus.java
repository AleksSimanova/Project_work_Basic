package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbsPopus extends AbsPageObject implements IPopus {

    public AbsPopus(WebDriver driver) {
        super(driver);
    }

    public By setNameTitle;

    @Override
    public void laterVisiboleState(By setNameTitle) {
        this.setNameTitle = setNameTitle;
        assertThat(waiters.waitFroElementVisibole(setNameTitle)).as("The item{} is not available", setNameTitle);

    }

    @Override
    public void instalInVisiboleState(By setNameTitle) {
        this.setNameTitle = setNameTitle;
        assertThat(waiters.waitFroElementInvisibole(setNameTitle)).as("The item {} is already available", setNameTitle);
    }
}
