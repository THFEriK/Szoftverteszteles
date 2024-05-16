package com.epam.ta.unideb.pageObjects;

import com.epam.ta.unideb.factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

//Ez egy kényelmi funkció, hogy ne kelljen mindig példányosítani
@Component
public class ArticlesPage extends CommonPageObject {
    public ArticlesPage(WebDriverFactory factory) {
        super(factory);
    }
    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(css = ".show .evnt-dropdown-menu .evnt-text-fields")
    private WebElement searchDropdownField;

    @FindBy(css = ".evnt-articles-wrapper .evnt-card-wrapper .evnt-text-body")
    private WebElement card;

    @FindBy(css = ".evnt-articles-wrapper .evnt-articles-row .evnt-articles-column")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-filters-wrapper #filter_community")
    private WebElement communityFilterButton;

    @FindBy(css = ".evnt-filters-wrapper #filter_tag")
    private WebElement tagFilterButton;

    @FindBy(css = ".evnt-filters-wrapper .show-more")
    private WebElement moreFiltersButton;
    @FindBy(css = ".evnt-filters-content-cell.evnt-results-cell p span")
    private WebElement resultsSpan;
    @FindBy(css = "#filter_language")
    private WebElement languageFilterButton;
    @FindBy(css = ".evnt-checkbox.form-check .form-check-label")
    private List<WebElement> languageLabels;
    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void dropdownSearchFor(String searchTerm) { searchDropdownField.sendKeys(searchTerm); }

    public void selectCheckboxFromSuggestedResults(String checkboxValue) { getCheckbox(checkboxValue).click(); }

    public void clickCommunityFilter() {
        communityFilterButton.click();
    }

    public void clickTagFilter() { tagFilterButton.click();}

    public void clickMoreFilters() { moreFiltersButton.click(); }

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

    public List<WebElement> getCards() {
        return cards;
    }

    public WebElement getCheckbox(String checkboxValue) {
        return WebDriverFactory.getInstance().findElement(By.xpath("//label[normalize-space()='" + checkboxValue + "']"));
    }

    public void clickLanguageFilter() { languageFilterButton.click(); }

    public void selectLanguageCheckbox(String language) {
        for (int i = 0; i < languageLabels.size(); i++) {
            if (languageLabels.get(i).getText().equals(language)) {
                languageLabels.get(i).click();
                break;
            }
        }
    }

    public int getResultCountOnPage() {
        String resultsString = resultsSpan.getText();
        int results = Integer.parseInt(resultsString);

        return results;
    }
}