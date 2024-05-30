package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoursesPage extends AbsPageBase {

    String expectedTitle = "";

    public CoursesPage(WebDriver driver, String nameCourse) {
        super(driver);
        this.expectedTitle = nameCourse;
    }

    private String title = "h1";

    @FindBy(xpath = "//h1/following-sibling::*[1]")
    private WebElement descriptionCourse;

    @FindBy(xpath = "//h1/ancestor::section/descendant::p[contains(text(), 'лайн')]")
    private WebElement formatCourse;

    @FindBy(xpath = "//h1/ancestor::section/descendant::p[contains(text(), 'месяц')]")
    private WebElement termCourse;

    WebElement titleCourse = $(By.cssSelector(title));
    String getTitle = $(By.cssSelector(title)).getText();

    public CoursesPage pageTitleCourse() {
        waiters.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector(title)));
        assertThat(titleCourse.getText())
                .as("There is no course name")
                .isEqualTo(expectedTitle);
        return this;
    }

    public CoursesPage courseDescription() {
        assertThat(descriptionCourse.getText().length()).isNotNull()
                .as("No course description{}", getTitle);
        return this;
    }

    public CoursesPage courseFormat() {
        assertThat(formatCourse.getText().length()).isNotNull()
                .as("The course format is not specified{}", getTitle);
        return this;
    }

    public CoursesPage courseTerm() {
        assertThat(formatCourse.getText().length()).isNotNull()
                .as("The duration of the course is not specified{}", getTitle);
        return this;
    }
}
