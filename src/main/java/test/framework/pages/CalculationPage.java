

package test.framework.pages;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.framework.base.component.Page;

import static java.lang.Thread.sleep;

@Slf4j
public class CalculationPage extends Page {

    public CalculationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input")
    WebElement formulaInput;

    @FindBy(css = "#BtnCalc")
    WebElement enterButton;

    @FindBy(css = "#hist > button.btn.dropdown-toggle.pull-right")
    WebElement historyButton;

    @FindBy(css = "#histframe > ul > li:nth-child(4) > p.l")
    WebElement historyExpression4;

    @FindBy(css = "#histframe > ul > li:nth-child(4) > p.r")
    WebElement historyResult4;


    @FindBy(css = "#histframe > ul > li:nth-child(3) > p.l")
    WebElement historyExpression3;

    @FindBy(css = "#histframe > ul > li:nth-child(3) > p.r")
    WebElement historyResult3;

    @FindBy(css = "#histframe > ul > li:nth-child(2) > p.l")
    WebElement historyExpression2;

    @FindBy(css = "#histframe > ul > li:nth-child(2) > p.r")
    WebElement historyResult2;

    @FindBy(css = "#histframe > ul > li:nth-child(1) > p.l")
    WebElement historyExpression1;

    @FindBy(css = "#histframe > ul > li:nth-child(1) > p.r")
    WebElement historyResult1;


    @Step("Check history 4")
    public Boolean checkHistory4(String expectedHistoryExpression, String expectedHistotyResult) {
        log.info("Check history 4");
        String historyExpression = historyExpression4.getAttribute("data-inp");
        String historyResult = historyResult4.getAttribute("title");
        if ((historyExpression.equals(expectedHistoryExpression)) && (historyResult.equals(expectedHistotyResult)))
        {
            return true;
        }
        else {
            return false;
        }

    }

    @Step("Check history 3")
    public Boolean checkHistory3(String expectedHistoryExpression, String expectedHistotyResult) {
        log.info("Check history 3");
        String historyExpression = historyExpression3.getAttribute("data-inp");
        String historyResult = historyResult3.getAttribute("title");
        if ((historyExpression.equals(expectedHistoryExpression)) && (historyResult.equals(expectedHistotyResult)))
        {
            return true;
        }
        else {
            return false;
        }

    }

    @Step("Check history 2")
    public Boolean checkHistory2(String expectedHistoryExpression, String expectedHistotyResult) {
        log.info("Check history 2");
        String historyExpression = historyExpression2.getAttribute("data-inp");
        String historyResult = historyResult2.getAttribute("title");
        if ((historyExpression.equals(expectedHistoryExpression)) && (historyResult.equals(expectedHistotyResult)))
        {
            return true;
        }
        else {
            return false;
        }

    }

    @Step("Check history 1")
    public Boolean checkHistory1(String expectedHistoryExpression, String expectedHistotyResult) {
        log.info("Check history 1");
        String historyExpression = historyExpression1.getAttribute("data-inp");
        String historyResult = historyResult1.getAttribute("title");
        if ((historyExpression.equals(expectedHistoryExpression)) && (historyResult.equals(expectedHistotyResult)))
        {
            return true;
        }
        else {
            return false;
        }

    }


    @Step("User set formula in  input field")
    public CalculationPage enterFormula(String formula) {
        log.info("Set formula {}", formula);
        formulaInput.sendKeys(formula);
        return this;
    }

    @Step("Clean Input TextBox")
    public CalculationPage cleanInputTextbox() {
        log.info("Clean Input TextBox");
        formulaInput.clear();
        return this;
    }

    @Step("Click Enter")
    public CalculationPage clickEnter() {
        log.info("Click Enter");
        enterButton.click();
        return this;
    }

    @Step("Get Output")
    public String getOutput(String inputText) throws InterruptedException {
        log.info("Get Output");

        sleep(1000);
        return formulaInput.getAttribute("value");
    }

    @Step("Click on History Button")
    public CalculationPage openHistory() throws InterruptedException {
        log.info("Get Output");
        historyButton.click();
        sleep(1000);

        return this;
    }



}