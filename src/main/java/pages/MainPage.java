package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import data.cources.CourseDataMenu;



public class MainPage extends AbsPageBase{
    Actions action =new Actions(driver);

    public MainPage(WebDriver driver){
        super(driver);
    }  



    private static final String CATEGORIES_MENU_TEMPLATE="//div[./h2[text()='Авторские онлайн‑курсы для профессионалов']]/following-sibling::section//*[text()='%s']";
    
    
    public CatalogPage clickCoursesCatrgoriesMenu(CourseDataMenu courseDataMenu){
        String locator =String.format(CATEGORIES_MENU_TEMPLATE, courseDataMenu.getName());
        $(By.xpath(locator)).click();
        return new CatalogPage(driver);
    }





}
