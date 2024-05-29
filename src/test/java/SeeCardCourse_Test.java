
import exceptions.DriverNotSupportedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import data.cources.CourseDataMenu;
import factory.DriverFactory;
import pages.MainPage;


public class SeeCardCourse_Test {

    private WebDriver driver;
    @BeforeEach
    public void init() throws DriverNotSupportedException {
        this.driver = new DriverFactory().create();
    }
    @AfterEach
    public void close(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
        public void seeCardCourse(){
        MainPage mainPage=new MainPage(driver);
        mainPage.open();
        mainPage
            .clickCoursesCatrgoriesMenu(CourseDataMenu.TESTING)
            .pageHeaderMatch("Каталог")
            .switchingСoursesPage(4)
            .pageTitleCourse()
            .сourseDescription()
            .courseFormat()
            .courseTerm();

        }
}


