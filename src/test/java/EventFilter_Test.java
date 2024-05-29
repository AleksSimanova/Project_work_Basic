import exceptions.DriverNotSupportedException;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import popups.EvenstType;
import popups.HeaderTrainingPopup;

public class EventFilter_Test {
    private WebDriver driver;

    @BeforeEach
    public void init()  throws DriverNotSupportedException {
        this.driver = new DriverFactory().create();
    }
    @AfterEach
    public void close(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
    public void eventFiltersCourses(){
        MainPage mainPage=new MainPage(driver);
        mainPage.open();

        new HeaderTrainingPopup(driver)
            .clickCalendareEvents()
            .pageHeaderMatch("Календарь мероприятий");
        new EvenstType (driver)
            .clickCalendareEvents()
            .selectingAnEventFilter("Открытый вебинар");
    }

}
