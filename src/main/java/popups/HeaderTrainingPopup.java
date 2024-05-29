package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CalendareEvents;

public class HeaderTrainingPopup extends AbsPopus {
    Actions action =new Actions(driver);

    public HeaderTrainingPopup(WebDriver driver) {
        super(driver);
        
    }
    private String stydyHeaderElementCSS = "span[title='Обучение']";
    private String calendareOfEventsXPath="//a[text()='Календарь мероприятий']";
    public String setNameTitle="";


    public CalendareEvents clickCalendareEvents(){
        By setNameTitle=By.xpath(calendareOfEventsXPath);
        instalInVisiboleState(setNameTitle);
        WebElement stydyHeaderElement=$(By.cssSelector(stydyHeaderElementCSS));
        action.moveToElement(stydyHeaderElement).build().perform();
        laterVisiboleState(setNameTitle);
        $(setNameTitle).click();
    return new CalendareEvents(driver);
    }

}
