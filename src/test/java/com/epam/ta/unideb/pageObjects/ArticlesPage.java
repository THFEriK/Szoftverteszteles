package com.epam.ta.unideb.pageObjects;

import com.epam.ta.unideb.factory.WebDriverFactory;
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

    @FindBy(css = ".evnt-articles-wrapper .evnt-card-wrapper .evnt-text-body")
    private WebElement card;

    @FindBy(css = ".evnt-articles-wrapper .evnt-articles-row .evnt-articles-column")
    private List<WebElement> cards;

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardcountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }

}