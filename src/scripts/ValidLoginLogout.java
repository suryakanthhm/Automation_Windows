package scripts;

import generics.Excel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.EnterTimeTrackPage;
import pom.LoginPage;

public class ValidLoginLogout extends BaseTest {
	
	@Test
	public void testValidLoginLogout () throws Exception {
		
		String un = Excel.getCellValue(XL_PATH, "ValidLoginLogout", 1, 0);
		String pw = Excel.getCellValue(XL_PATH, "ValidLoginLogout", 1, 1);
		String eTitle = Excel.getCellValue(XL_PATH, "ValidLoginLogout", 1, 2);
		
		LoginPage l = new LoginPage(driver);
		
		l.verifyPageTitle(eTitle);		
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();

		EnterTimeTrackPage l1 = new EnterTimeTrackPage(driver);
		
		WebDriverWait w = new WebDriverWait(driver, 60);	
		w.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		l1.clickLogout();
		
		l.verifyPageTitle(eTitle);
		
	}
}
