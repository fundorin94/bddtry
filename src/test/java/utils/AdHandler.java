package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;


public class AdHandler {

    private final By iframeLocator = By.cssSelector("iframe[id*='google_ads_iframe_/6581/web/gb/interstitial/news_info/country_home_0']");
    private final By closeButtonLocator = By.cssSelector("#dismiss-button");
    private final IElement closeAdButton = AqualityServices.getElementFactory().getLabel(closeButtonLocator, "Close Ad Button");

    public void closeAd() {
        AqualityServices.getBrowser().getDriver().switchTo().frame(AqualityServices.getBrowser().getDriver().findElement(iframeLocator));

        closeAdButton.click();

        AqualityServices.getBrowser().getDriver().switchTo().defaultContent();
    }
}
