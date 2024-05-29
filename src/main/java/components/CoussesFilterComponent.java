package components;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import data.cources.CourseDataMenu;
import pageObject.AbsPageObject;


public class CoussesFilterComponent extends AbsPageObject{
    public CoussesFilterComponent(WebDriver driver) {
        super(driver);
    }
    private String filterMenuItemLocator="//*[@aria-hidden='false']//div[./label='%s']";

    public CoussesFilterComponent checkCheckboxFilterStateShoulBeSameAS(CourseDataMenu courseData,boolean isExpectedState){
        String locator=String.format(filterMenuItemLocator, courseData.getName());
        assertThat(waiters.waitForCondition(ExpectedConditions.attributeToBe(
            $(By.xpath(locator)),"valie",String.valueOf(isExpectedState)
                )))
            .as("element not visibel")
            .isTrue();
        return this;
    }  
    
}
