package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import utils.AdHandler;
import static io.qameta.allure.Allure.step;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();
    private final AdHandler adHandler = new AdHandler();

    /*@When("I consent data usage")
    public void consentDataUsage() {
        step("Consent data usage");
        mainPage.clickConsentButton();
    }*/

    @When("I input {string} in the search field")
    public void inputSearchQuery(String searchQuery) {
        step("Input search query: " + searchQuery);
        mainPage.inputSearchQuery(searchQuery);
    }

    @Then("Search results list is displayed")
    public void verifySearchResultsListIsDisplayed() {
        step("Verify that search results list is displayed");
        Assert.assertTrue(mainPage.isSearchResultsDisplayed(), "Search results is not displayed.");
    }

    @When("I click on the first search result")
    public void clickOnFirstSearchResult() {
        step("Click on the first search result");
        mainPage.clickFirstSearchResult();
    }

    @Then("Main page is opened")
    public void verifyMainPageIsOpened() {
        step("Verify that main page is opened");
        Assert.assertTrue(mainPage.isMainPageDisplayed(), "Main page is not displayed.");
    }

    @When("I choose the first city in Recent locations")
    public void chooseRecentLocationElement() {
        step("Choose the first city in Recent locations");
        mainPage.chooseRecentLocationElement();
    }

    @When("I close the Ad block")
    public void closeAdBlock() {
        step("Close the Ad block");
        adHandler.closeAd();
    }

    @When("I click search field")
    public void clickSearchField() {
        step("Click search field");
        mainPage.clickSearchField();
    }

    @Then("Use your current location label is displayed")
    public void verifyUseYourCurrentLocationLabelIsDisplayed() {
        step("Verify that Use your current location label is displayed");
        Assert.assertTrue(mainPage.isUseYourCurrentLocationDisplayed(), "Use your current location label is not displayed.");
    }
}






