package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogPage extends AbsPageBase {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private String layoutCourseXPath = "//section//div/child::a[./h6]";
    private static final String NUMBER_COURSE_XPATH = "//section//div/child::a[./h6][%d]";
    private String nameCardCourseXPath = NUMBER_COURSE_XPATH + "//h6//div";

    public CoursesPage switchingСoursesPage(int numberCourse) {
        String locatorCard = String.format(NUMBER_COURSE_XPATH, numberCourse);
        String nameLocator = String.format(nameCardCourseXPath, numberCourse);
        String nameCatdCours = $(By.xpath(nameLocator)).getText();
        waiters.waitForCondition(ExpectedConditions.elementToBeClickable(By.xpath(locatorCard)));
        $(By.xpath(locatorCard)).click();
        return new CoursesPage(driver, nameCatdCours);
    }


    public CatalogPage pageHeaderMatch(String expectedHeader) {
        By headerSelector = By.cssSelector("h1>div");
        waiters.waitForCondition(ExpectedConditions.presenceOfElementLocated(headerSelector));
        assertThat($(headerSelector).getText())
                .as("header of page should be same as{}", expectedHeader)
                .isEqualTo(expectedHeader);
        return this;
    }

    public CatalogPage numbersOfCourses(int expectedPlenty) {
        List<WebElement> listCourses = driver.findElements(By.xpath(layoutCourseXPath));
        assertThat(listCourses.size())
                .as("The length does not match{}", expectedPlenty)
                .isEqualTo(expectedPlenty);
        return this;
    }
}
