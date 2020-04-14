

package test.framework.base;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import test.framework.base.Application;
import test.framework.base.factory.DriverFactoryProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    private WebDriver driver;
    protected Application application;

    @BeforeEach
    public void setUpBeforeEach() {
        this.driver = new DriverFactoryProvider().getDriverFactory().getDriver();
        application = new Application(driver);
    }

    @AfterEach
    public void cleanUpAfterEach() {
        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", makeScreenShot());
        application.close();
    }

    private byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
