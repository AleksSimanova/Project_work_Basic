package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import popups.Cookies;

public class CalendareEvents extends AbsPageBase {
    String nameFilter="";
    public CalendareEvents(WebDriver driver,String expectedNameFilter) {
        super(driver);
        this.nameFilter=expectedNameFilter;
    }
    public CalendareEvents(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "div.dod_new-header__title")
    private WebElement header;

    private String typeEventsCss = "a.dod_new-event div.dod_new-type__text";

    private String listDateNewEventsCss = "span.dod_new-event__date-text";



    List<LocalDate> eventsDates = new ArrayList<>();
    String expectedTypeFinter = "";

    public void conversionToLocalDate(List<WebElement> eventsData) {
        int year = LocalDate.now().getYear();
        try {
            for (WebElement event : eventsData) {
                String dataStr = String.valueOf(event);
                String dataYearStr = String.format("%s %d", dataStr, year);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("ru-RU"));
                LocalDate date = LocalDate.parse(dataYearStr, formatter);
                eventsDates.add(date);
            }
        } catch (DateTimeException ignore) {
            System.out.println("ошибка DataTime");
        }
    }

    public void actualDate(List<LocalDate> eventsDates) {
        for (LocalDate date : eventsDates) {
            assertThat(LocalDate.now().isBefore(date)).as("the event is not relevant").isTrue();
        }
    }

    public CalendareEvents actualDataEvents() {
        List<WebElement> eventsData = $$(By.cssSelector(listDateNewEventsCss));
        conversionToLocalDate(eventsData);
        actualDate(eventsDates);
        return this;
    }

    public CalendareEvents newTypeCatd(){
            List<WebElement> listTypeCard=$$(By.cssSelector(typeEventsCss));
            for (WebElement element : listTypeCard) {
                assertThat(element.getText())
                            .as("The type of event does not match{}", nameFilter)
                            .isEqualTo(nameFilter);
                
            }
        return this;
    }

    public CalendareEvents pageHeaderMatch(String expectedHeader) {
        assertThat(header.getText())
                .as("header of page should be same as{}", expectedHeader)
                .isEqualTo(expectedHeader);
        new Cookies(driver).cooliesClick();
        return this;
    }
}


