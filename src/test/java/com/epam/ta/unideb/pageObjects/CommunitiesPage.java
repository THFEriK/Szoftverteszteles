package com.epam.ta.unideb.pageObjects;

import com.epam.ta.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommunitiesPage extends CommonPageObject {
    public CommunitiesPage(WebDriverFactory factory) {
        super(factory);
    }

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css = ".evnt-communities-row .evnt-communities-column .evnt-name-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-communities-row .evnt-communities-column")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-sorting-button.btn.dropdown-toggle")
    private WebElement sortByButton;

    @FindBy(css = ".evnt-dropdown-menu .dropdown-item:first-child")
    private WebElement alphabeticSortButton;

    @FindBy(css = ".Button-module__button__Oq73a.evnt-filter-button")
    private WebElement tagButton;

    @FindBy(css = " .evnt-filter-menu-search-wrapper .evnt-text-fields.form-control.evnt-search")
    private WebElement tagSearchField;

    @FindBy(css = ".evnt-filter-menu-scroll > .evnt-filter-menu-items-wrapper > .evnt-filter-item:first-child > .evnt-checkbox.form-check > .form-check-label")
    public WebElement eventKitCheckbox;

    @FindBy(css = "#filter_location.Button-module__dropdown__S4ts5.evnt-filter-button")
    public WebElement locationButton;

    @FindBy(css = ".evnt-filter-menu-items-wrapper .evnt-filter-item:first-child .evnt-filter-item-collapse .form-check-label")
    public WebElement armeniaCheckbox;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

    public void clickSortBy() {sortByButton.click();}

    public void clickAlphabeticSort() {alphabeticSortButton.click();}

    public void clickTag() {tagButton.click();}

    public void searchTagFor(String searchTerm) {
        tagSearchField.sendKeys(searchTerm);
    }

    public void checkEventKitOption() {eventKitCheckbox.click();}

    public void clickLocation() {locationButton.click();}

    public void checkArmeniaOption() {armeniaCheckbox.click();}
}
