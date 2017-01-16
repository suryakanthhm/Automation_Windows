package scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest implements AutoConst {
	
	public WebDriver driver;
	
	@Parameters({"remoteURL", "browser"})
	
	@BeforeMethod
	public void preConditions(String remoteURL, String browser) throws MalformedURLException {
		
		URL ra = new URL(remoteURL);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		
		driver = new RemoteWebDriver(ra,dc);
	
		driver.get("http://demo.actitime.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void postCoditions() {
		driver.close();
	}
	
}
