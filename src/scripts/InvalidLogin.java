package scripts;

import generics.Excel;
import org.testng.annotations.Test;
import pom.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test
	public void testInvalidLogin() throws Exception {
		
		int rCount=Excel.getRowCount(XL_PATH, "InvalidLogin");		
		
		LoginPage l1 = new LoginPage(driver);
		
		for(int i=1; i<=rCount; i++)
		{
			String un=Excel.getCellValue(XL_PATH, "InvalidLogin", i, 0);
			String pw=Excel.getCellValue(XL_PATH, "InvalidLogin", i, 1);
			
			l1.setUsername(un);
			l1.setPassword(pw);
			l1.clickLogin();
			
			l1.verifyErrMsg();
			Thread.sleep(3000);	
		}
	}

}
