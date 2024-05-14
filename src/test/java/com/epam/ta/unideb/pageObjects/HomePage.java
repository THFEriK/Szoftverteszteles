package com.epam.ta.unideb.pageObjects;

import com.epam.ta.unideb.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

//Ez egy kényelmi funkció, hogy ne kelljen mindig példányosítani
@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "https://wearecommunity.io/";

    //szelektort adunk meg, amivel megfogjuk az elementet
    @FindBy(className = "communities-icon")
    private WebElement communitiesButton;

    @FindBy(className = "events-icon")
    private WebElement eventsButton;
    @FindBy(className = "articles-icon")
    private WebElement articlesButton;
    @FindBy(css = ".evnt-tools-menu.language.nav-item")
    private WebElement languageButton;
    @FindBy(css = "#language-menu-dropdown > a:nth-child(3)")
    private WebElement russianLangButton;

    public HomePage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickCommunities() {
        communitiesButton.click();
    }

    public void clickEvents() {
        eventsButton.click();
    }

    public void clickArticles() { articlesButton.click(); }

    public void clickLanguages() { languageButton.click();}
    public void clickRussianLang() {russianLangButton.click();}
}
