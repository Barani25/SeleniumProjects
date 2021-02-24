package parallel;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	// private varibles , these 2 varibles are used inside this calss ,
	// these 2 variables ae specific to this partucylar class

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	// to get the init_prop method from the config reader methid,
	// it reads the value from config.properties file.
	// create a object for the class which method you want to access
	@Before(order = 0)
	public void getProperty() throws IOException {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	// to launch the browser , call the init_driver method. create object amd call
	// that ,method
	// pass this prop value as a key to init_driver method
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
  
	

	@After(order = 1)
	public void tearDown(Scenario scenario) {
	
			if (scenario.isFailed()) {
				// take screenshot:
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);

			}
	}

}
