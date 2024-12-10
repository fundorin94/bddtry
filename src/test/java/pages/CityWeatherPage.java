package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CityWeatherPage extends Form {

    private static final By headerNameLocator = By.cssSelector(".header-loc");
    private final ILabel headerName = getElementFactory().getLabel(headerNameLocator, "City Name Header");


    public CityWeatherPage() {
        super (By.cssSelector(".card-header.spaced-content"), "Weather Radar");
    }

    public String getCityNameHeaderText() {
        return headerName.getText();
    }

    public boolean isCityWeatherPageDisplayed() {
        return headerName.state().waitForDisplayed();
    }
}


