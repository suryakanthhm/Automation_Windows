package scripts;

import generics.Excel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.EnterTimeTrackPage;
import pom.LoginPage;

public class VerifyProdVersion extends BaseTest {
	
	@Test
	public void testVerifyProdVersion () throws Exception {
	
		String un=Excel.getCellValue(XL_PATH, "VerifyProdVersion", 1, 0);
		String pw=Excel.getCellValue(XL_PATH, "VerifyProdVersion", 1, 1);
		String eTitle=Excel.getCellValue(XL_PATH, "VerifyProdVersion", 1, 2);
		
		LoginPage l1 = new LoginPage(driver);
		l1.verifyPageTitle(eTitle);
		l1.setUsername(un);
		l1.setPassword(pw);
		l1.clickLogin();
		
		WebDriverWait w1 = new WebDriverWait(driver, 60);
		w1.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		EnterTimeTrackPage e1 = new EnterTimeTrackPage(driver);
		e1.clickHelp();
		e1.clickAboutActiTime();
		String x=e1.getProdVersion();
		Reporter.log(x,true);
		Thread.sleep(2000);
		
		e1.prodInfoClose();
		e1.clickLogout();
		
		l1.verifyPageTitle(eTitle);	
	}
}
