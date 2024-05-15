package com.epam.ta.unideb.stepdefinition;

import com.epam.ta.unideb.factory.WebDriverFactory;
import com.epam.ta.unideb.pageObjects.ArticlesPage;
import com.epam.ta.unideb.pageObjects.CommunitiesPage;
import com.epam.ta.unideb.pageObjects.EventsPage;
import com.epam.ta.unideb.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class StepDefinitions {

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private HomePage homePage;

    @Autowired
    private CommunitiesPage communitiesPage;

    @Autowired
    private EventsPage eventsPage;
    @Autowired
    private ArticlesPage articlesPage;

    @Given("the communities portal is opened")
    public void communitiesPortalOpened() {
        WebDriverFactory.getInstance().get("https://wearecommunity.io/");
    }

    @When("I click the communities button")
    public void iClickTheCommunitiesButton() {
        homePage.clickCommunities();
    }

    @When("I click the events button")
    public void iClickTheEventsButton() {
        homePage.clickEvents();
    }

    @When("I click the articles button")
    public void iClickTheArticlesButton() { homePage.clickArticles();}

    @And("I type {string} in search")
    public void iTypeInSearch(String searchString) {
        communitiesPage.searchFor(searchString);
    }

    @Then("I see the {string} card")
    public void iSeeTheCard(String title) {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(communitiesPage.getCard(), title));
    }

    @And("I see {int} card")
    public void iSeeCard(int count) {
        Assert.assertEquals(count, communitiesPage.getCardcountOnPage());
    }

    @And("I type {string} in search on Events Page")
    public void iTypeInSearchEvents(String searchString) {
        eventsPage.searchFor(searchString);
    }

    @Then("I see the {string} card on Events Page")
    public void iSeeTheCardEvents(String title) {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(eventsPage.getCard(), title));
    }

    @And("I see {int} card on Events Page")
    public void iSeeCardEvents(int count) {
        Assert.assertEquals(count, eventsPage.getCardcountOnPage());
    }

    @And("I type {string} in search on Articles Page")
    public void iTypeInSearchArticles(String searchString) {
        articlesPage.searchFor(searchString);
    }

    @Then("I see the {string} card on Articles Page")
    public void iSeeTheCardArticles(String title) {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(articlesPage.getCard(), title));
    }

    @And("I see {int} card on Articles Page")
    public void iSeeCardArticles(int count) {
        Assert.assertEquals(count, articlesPage.getCardcountOnPage());
    }

    @And("I click the Sort by button")
    public void clickSortByButton(){communitiesPage.clickSortBy();}

    @Then("I see the dropdown menu")
    public void iSeeDropdownMenu() {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".evnt-sorting-dropdown.show")));
    }

    @When("I click the A - Z button")
    public void clickAlphabeticSortButton(){communitiesPage.clickAlphabeticSort();}

    @Then("the cards should be in alphabetic order")
    public void verifyAlphabeticalOrderInCommunities() {

        //just wait for sorting to actually happen
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedTitle = "accessibility expertise";

        WebElement cardTitleElement = new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(".evnt-communities-row .evnt-communities-column:nth-child(1) .evnt-community-card h2")));

        String actualTitle = cardTitleElement.getText().toLowerCase();

        Assert.assertEquals(expectedTitle, actualTitle);

    }
    @And("I click the past events button")
    public void clickPastEventsButton(){ eventsPage.clickPastEvents();}
    @Then("I see the past events")
    public void iSeePastEvents() throws ParseException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cardDateElement = new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".evnt-card-wrapper .evnt-card-heading .evnt-details-cell.date-cell")));
        String actualDate = cardDateElement.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        Date date = formatter.parse(actualDate);
        Assert.assertTrue(new Date().after(date));

    }
    @When("I click the upcoming events button")
    public void clickUpcomingEventsButton(){eventsPage.clickUpcomingEvents();}
    @Then("I see the upcoming events")
    public void iSeeUpcomingEvents() throws ParseException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cardDateElement = new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div > main > section.evnt-panel.evnt-events-panel > div > div > div.evnt-events-tabs-container.tab-content > div > div.evnt-cards-container.with-sorting > div.evnt-events-row > div:nth-child(1) > div > a > div > div.evnt-card-heading > div > div > p")));
        String actualDate = cardDateElement.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        Date date = formatter.parse(actualDate.substring(4));
        Assert.assertTrue(new Date().before(date));

    }
    @And("I click the eng button")
    public void clickLanguagesButton(){ homePage.clickLanguages();}
    @Then("I see the language dropdown menu")
    public void iSeeLanguageDropdownMenu() {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".evnt-tools-menu.language.nav-item.show")));
    }
    @When("I click the Русский button")
    public void clickRussianLangButton(){homePage.clickRussianLang();}
    @Then("The site language should be russian")
    public void iSeeTheCardArticles() {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(By.cssSelector("#popular > div > span"),"Популярные"));
    }

    @And("I click on the Tag button")
    public void clickTagButton(){communitiesPage.clickTag();}

    @Then("I see the tag dropdown menu")
    public void iSeeTagDropdownMenu() {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".evnt-filter-menu.evnt-dropdown-menu.dropdown-menu.with-arrow.show")));
    }

    @When("I type {string} in search on Tag dropdown")
    public void iTypeInSearchOnTagDropdown(String searchTagString) {
        communitiesPage.searchTagFor(searchTagString);
    }

    @Then("I see the checkbox menu")
    public void iSeeTheCheckboxMenu() {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".evnt-filter-menu-scroll .evnt-filter-menu-items-wrapper")));

        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(communitiesPage.eventKitCheckbox));
    }

    @When("I check the first option on the checkbox menu")
    public void iCheckTheOption() {
        communitiesPage.checkEventKitOption();
    }

    @Then("I see the {string} card on Communities page")
    public void iSeeTheCardOnCommunitiesPage(String title) {
        new WebDriverWait(WebDriverFactory.getInstance(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(communitiesPage.getCard(), title));
    }
}
