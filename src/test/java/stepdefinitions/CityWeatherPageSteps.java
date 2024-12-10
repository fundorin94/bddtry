package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CityWeatherPage;
import static io.qameta.allure.Allure.step;

public class CityWeatherPageSteps {

    private final CityWeatherPage cityWeatherPage = new CityWeatherPage();


    @Then("City weather page header contains city name {string} from the search")
    public void verifyCityNameHeaderContainsSearchQuery(String searchQuery) {
        step("Verify that city name header contains the search query: " + searchQuery);
        Assert.assertTrue(cityWeatherPage.getCityNameHeaderText().contains(searchQuery),
                "City name header does not contain the search query: " + searchQuery);
    }
}

