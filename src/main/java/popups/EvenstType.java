package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CalendareEvents;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EvenstType extends AbsPopus {
    public EvenstType(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    private String eventsTypeCss = "div.dod_new-events__header-left div.dod_new-events-dropdown__input>span";

    private String openingTheFilterCss = "div.dod_new-events-dropdown_opened";

    private static final String FILTERS_BE_EVENTES_CSS = "div.dod_new-events__header-left a.dod_new-events-dropdown__list-item[title='%s']";

    private String getTypeEventsCss = "div.dod_new-events-dropdown";


    String expectedTypeFilter = "";

    public EvenstType clickCalendareEvents() {
        By openingTheFilter = By.cssSelector(openingTheFilterCss);
        instalInVisiboleState(openingTheFilter);
        $(By.cssSelector(getTypeEventsCss)).click();
        laterVisiboleState(openingTheFilter);
        return new EvenstType(driver);
    }

    public CalendareEvents selectingAnEventFilter(String expectedTypeFilter) {
        this.expectedTypeFilter = expectedTypeFilter;
        $(By.cssSelector(String.format(FILTERS_BE_EVENTES_CSS, expectedTypeFilter))).click();
        return new CalendareEvents(driver,expectedTypeFilter);
    }
}
    

