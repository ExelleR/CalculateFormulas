

package test.framework.base.factory;

import io.github.bonigarcia.wdm.DriverManagerType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import test.framework.base.factory.loader.ChromeDriverLoader;
import test.framework.base.factory.loader.FirefoxDriverLoader;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
public class LocalDriverFactory implements IDriverFactory {

    @Override
    public WebDriver getDriver() {
        DriverManagerType driverType;
        WebDriver driver;
        try {
            driverType = DriverManagerType.valueOf(configuration.browserName().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Wrong browserName, supported browsers:\n" +
                    Arrays.toString(
                            Stream.of(DriverManagerType.values())
                                    .map(DriverManagerType::name)
                                    .toArray(String[]::new)));
        }
        switch (driverType) {
            case CHROME:
                ChromeDriverLoader.load();
                driver = new ChromeDriver((ChromeOptions) BrowserOptionsFactory.getOptions());
                break;
            case FIREFOX:
                FirefoxDriverLoader.load();
                driver = new FirefoxDriver((FirefoxOptions) BrowserOptionsFactory.getOptions());
                break;
            default:
                log.warn("Browser not provided, using default one");
                ChromeDriverLoader.load();
                driver = new ChromeDriver((ChromeOptions) BrowserOptionsFactory.getOptions());
                break;
        }
        return driver;
    }
}