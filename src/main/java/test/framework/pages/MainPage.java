

package test.framework.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.framework.base.component.Page;

@Slf4j
public class MainPage extends Page {


    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#cookieconsentallowall")
    private WebElement allowCookies;


    @Step("Allow cookies")
    public CalculationPage allowCookies() {
        log.info("Allow cookies");
        this.allowCookies.click();
        return pageFactory.create(CalculationPage.class);
    }


}