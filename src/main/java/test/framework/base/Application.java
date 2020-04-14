

package test.framework.base;

import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import test.framework.base.component.Page;
import test.framework.configuration.Configuration;
import test.framework.pages.MainPage;

@Slf4j
public class Application extends Page {
    private static Configuration configuration = ConfigFactory.create(Configuration.class);

    public Application(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage open() {
        String applicationAddress = configuration.applicationAddress();
        log.info("Opening application at: {}", applicationAddress);

        driver.get(applicationAddress);
        return pageFactory.create(MainPage.class);
    }



    public void close() {
        log.info("Closing application");
        driver.quit();
    }
}