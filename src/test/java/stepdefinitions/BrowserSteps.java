package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.When;
import pages.CityWeatherPage;


import static io.qameta.allure.Allure.step;

public class BrowserSteps {

    private final CityWeatherPage cityWeatherPage = new CityWeatherPage();


        @When("I go back to the main page")
        public void goBackToMain() {
            step("Go back to the main page");
            //fdhfd
            //I tried to use the ElementState.DISPLAYED, but test was failed, that is why Conditional Wait is used here

            AqualityServices.getConditionalWait().waitFor(cityWeatherPage::isCityWeatherPageDisplayed);
            AqualityServices.getBrowser().goBack();
        }
}


