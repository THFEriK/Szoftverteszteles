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
    @FindBy(css = ".evnt-filters-wrapper #filter_location")
    private WebElement locationFilterButton;
    @FindBy(css = ".evnt-toggle-filters-button")
    private WebElement moreFiltersButton;
    @FindBy(css = ".evnt-filters-wrapper #filter_speaker")
    private WebElement speakerFilterButton;
    @FindBy(css = ".evnt-filters-wrapper #filter_language")
    private WebElement languageFilterButton;
    @FindBy(css = ".evnt-default-filters .evnt-filters-heading-cell:nth-child(3) .evnt-search")
    private WebElement locationSearchField;
    @FindBy(css = ".evnt-more-filters .evnt-filters-heading-cell:nth-child(3) .evnt-search")
    private WebElement speakerSearchField;
    @FindBy(css = ".evnt-default-filters .evnt-filters-heading-cell:nth-child(3) .evnt-filter-menu-items-wrapper .evnt-filter-item:first-child .evnt-filter-item-collapse .form-check-label")
    public WebElement locationCheckBox;
    @FindBy(css = ".evnt-more-filters .evnt-filters-heading-row:first-child .evnt-filters-heading-cell:nth-child(3) .evnt-filter-menu-items-wrapper .evnt-filter-item:first-child  .form-check-label")
    public WebElement speakerCheckBox;

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
    public void clickLocationButton() {locationFilterButton.click();}
    public void clickMoreFiltersButton() {moreFiltersButton.click();}
    public void clickSpeakerButton() {speakerFilterButton.click();}
    public void clickLanguageButton() {languageFilterButton.click();}
    public void searchLocationFor(String searchTerm) {
        locationSearchField.sendKeys(searchTerm);
    }

    public void searchSpeakerFor(String searchTerm) {
        speakerSearchField.sendKeys(searchTerm);
    }

    public void checkLocationCheckBox() {locationCheckBox.click();}
    public void checkSpeakerCheckBox() {speakerCheckBox.click();}

}
