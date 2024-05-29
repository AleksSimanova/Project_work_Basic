package popups;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pages.CalendareEvents;

public class EvenstType extends AbsPopus{
    public EvenstType(WebDriver driver) {
        super(driver);
    }
    Actions action =new Actions(driver);

    private String eventsTypeCss="div.dod_new-events__header-left div.dod_new-events-dropdown__input>span";
    private String openingTheFilterCss="div.dod_new-events-dropdown_opened";
    private static  final String FILTERS_BE_EVENTES_CSS="div.dod_new-events__header-left a.dod_new-events-dropdown__list-item[title='%s']";
    private String getTypeEventsCss="div.dod_new-events-dropdown";

    public EvenstType clickCalendareEvents(){
        // String headerSelectorCssStr=String.format(FILTERS_BE_EVENTES_CSS,getNameTitle);
        // By headerSelectorCss=By.cssSelector(headerSelectorCssStr);
        By openingTheFilter=By.cssSelector(openingTheFilterCss);
        instalInVisiboleState(openingTheFilter);
        $(By.cssSelector(getTypeEventsCss)).click();
        laterVisiboleState(openingTheFilter);
    return new EvenstType(driver);
    
    }
    String expectedTypeFinter="";
    public CalendareEvents selectingAnEventFilter(String expectedTypeFinter){
        this.expectedTypeFinter=expectedTypeFinter;
        $(By.cssSelector(String.format(FILTERS_BE_EVENTES_CSS, expectedTypeFinter))).click();
        // WebElement el = $(By.cssSelector(eventsTypeCss));
        // assertThat(el.getText()).as("The type of event does not correspond{}",expectedTypeFinter).isEmpty();

        return new CalendareEvents(driver);
    }
}
    

