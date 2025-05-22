package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import utils.EnvDataReader;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static io.qameta.allure.Allure.step;

public class Hooks {
    protected Browser browser = AqualityServices.getBrowser();

    @Before()
    public void setup() {
        step("Maximize browser window");
        getBrowser().maximize();
        step("Open the page");
        getBrowser().goTo(EnvDataReader.getEnvData().getHost());
    }

    @After()
    public void teardown() {
        step("Attach screenshot before quitting");
        attachScreenshot(); // <-- Скриншот сохраняется в Allure
        step("Quitting browser");
        if (AqualityServices.isBrowserStarted()) getBrowser().quit();
    }

    @Attachment(value = "Last screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return getBrowser().getDriver().getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }
}