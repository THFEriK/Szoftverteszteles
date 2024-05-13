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

import java.time.Duration;

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
}
