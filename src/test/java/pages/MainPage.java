package pages;

import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

public class MainPage extends Form {

    private static final By searchFieldLocator = By.cssSelector(".search-input");
    private static final By useYourCurrentLocationLocator = By.cssSelector(".search-bar-result.current-location-result");
    private static final By recentLocationLocator = By.cssSelector("*[data-location-key='328328']");
    private static final By buttonConsentLocator = By.cssSelector(".banner-button.policy-accept");
    private static final By searchResultsLocator = By.cssSelector(".search-bar-result.search-result");
    private static final By searchResultsContainerLocator = By.cssSelector(".results-container");

    private final ITextBox searchField = getElementFactory().getTextBox(searchFieldLocator, "Search Field");
    private final IButton consentButton = getElementFactory().getButton(buttonConsentLocator, "Consent Button");
    private final IElement searchResultsContainer = getElementFactory().getLabel(searchResultsContainerLocator, "Search Results Container");
    private final IElement recentLocationElement = getElementFactory().getLabel(recentLocationLocator, "Recent Location Element");
    private final ILabel yourCurrentLocationLabel = getElementFactory().getLabel(useYourCurrentLocationLocator, "Use Your Current Location Label");


    public MainPage() {
        super(By.cssSelector(".searchbar-content"), "Main Page");
    }

    public void clickConsentButton() {
        consentButton.click();
    }

    public void clickSearchField() {
        searchField.click(); //fgfd
    }

    public void inputSearchQuery(String query) {
        searchField.clearAndType(query);
    }

    private List<IElement> getSearchResultsElements() {
        return AqualityServices.getElementFactory().findElements(searchResultsLocator, "Search results list", ElementType.LABEL, ElementsCount.MORE_THAN_ZERO);
    }

    public boolean isSearchResultsDisplayed() {
        return searchResultsContainer.state().waitForDisplayed();
    }

    public void clickFirstSearchResult() {
        getSearchResultsElements().get(0).click();
    }

    public void chooseRecentLocationElement() {
        recentLocationElement.click();
    }

    public boolean isUseYourCurrentLocationDisplayed() {
        return yourCurrentLocationLabel.state().waitForDisplayed();
    }

    public boolean isMainPageDisplayed() {
        return searchField.state().waitForDisplayed();
    }
}



