

package test.framework.base.factory;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import test.framework.configuration.Configuration;

public interface IDriverFactory {

    Configuration configuration = ConfigFactory.create(Configuration.class);

    WebDriver getDriver();
}