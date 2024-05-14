package com.epam.ta.unideb.pageObjects;

import com.epam.ta.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventsPage extends CommonPageObject {
    public EventsPage(WebDriverFactory factory) {
        super(factory);
    }

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css = ".evnt-events-row .evnt-events-column .evnt-card-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-events-row .evnt-events-column")
    private List<WebElement> cards;
    @FindBy(css = ".evnt-panel-wrapper .evnt-events-tabs-nav .evnt-tabs-list.nav.nav-tabs .evnt-tab-item.nav-item:nth-child(2) .evnt-tab-text.desktop")
    private WebElement pastEventsButton;
    @FindBy(css = "#app > div > main > section.evnt-panel.evnt-events-panel > div > div > div.evnt-events-tabs-nav > ul > li:nth-child(1) > a > span.evnt-tab-text.desktop")
    private WebElement upcomingEventsButton;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }
    public void clickPastEvents() { pastEventsButton.click();}
    public void clickUpcomingEvents() { upcomingEventsButton.click();}

}
