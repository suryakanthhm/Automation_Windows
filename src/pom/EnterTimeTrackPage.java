package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage extends BasePage {

	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
	private WebElement helpLink;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutActiTimeLink;
	
	@FindBy(xpath="//tr[@class='productVersionInfo']//td[contains(.,'actiTIME 201')]")
	private WebElement prodVersion;
	
	@FindBy(xpath="//img[@id='aboutPopupCloseButtonId']")
	private WebElement prodInfoMenuCloseButton;
	
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogout () {
		logoutLink.click();
	}
	
	public void clickHelp() {
		helpLink.click();
	}

	public void clickAboutActiTime () {
		aboutActiTimeLink.click();
	}
	
	public String getProdVersion() {
		String prodV = prodVersion.getText();
		return prodV;
	}
	
	public void prodInfoClose() {
		prodInfoMenuCloseButton.click();
	}
}
