package test.framework.calculate;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import test.framework.base.BaseTest;
import test.framework.pages.CalculationPage;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Calculate formulas.")
@Execution(ExecutionMode.CONCURRENT)
public class CalculateTest extends BaseTest {
    String input = "0";
    String result = "0";

    @Test
    @Tag("Calculate")
    @Feature("Calculate formula")
    public void calculateFormula1() throws InterruptedException {
        input = "2+3";

        CalculationPage calculationPage = application.open().allowCookies();
        assertThat(
                calculationPage
                        .enterFormula(input)
                        .clickEnter()
                        .getOutput(input)


        )
                .isEqualTo("5")
                .withFailMessage("Alert message is not displayed");
        calculationPage.cleanInputTextbox();

        input = "10-2";
        assertThat(
                calculationPage
                        .enterFormula(input)
                        .clickEnter()
                        .getOutput(input)

        )
                .isEqualTo("8")
                .withFailMessage("Alert message is not displayed");


        calculationPage.cleanInputTextbox();

        input = "(10-2)*2";
        assertThat(
                calculationPage
                        .enterFormula(input)
                        .clickEnter()
                        .getOutput(input)

        )
                .isNotEqualTo("20")
                .withFailMessage("Alert message is not displayed");

        calculationPage.cleanInputTextbox();


        input = "sin(30)";
        assertThat(
                calculationPage
                        .enterFormula(input)
                        .clickEnter()
                        .getOutput(input)

        )
                .isEqualTo("0.5")
                .withFailMessage("Alert message is not displayed");
        calculationPage.cleanInputTextbox();



        input = "2+3";
        result = "5";
        assertThat(
                calculationPage
                        .openHistory()
                        .checkHistory4(input,result)

        )
                .isTrue()
                .withFailMessage("Alert message is not displayed");


        input = "10-2";
        result = "8";
        assertThat(
                calculationPage
                        .checkHistory3(input,result)

        )
                .isTrue()
                .withFailMessage("Alert message is not displayed");

        input = "(10-2)*5";
        result = "20";
        assertThat(
                calculationPage
                        .checkHistory2(input,result)

        )
                .isFalse()
                .withFailMessage("Alert message is not displayed");

        input = "sin(30)";
        result = "0.5";
        assertThat(
                calculationPage
                        .checkHistory1(input,result)

        )
                .isTrue()
                .withFailMessage("Alert message is not displayed");

    }

}