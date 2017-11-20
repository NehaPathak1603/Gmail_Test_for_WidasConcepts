package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(xpath="html/body/nav/div/a[2]")
	private WebElement signInButton;
	@FindBy(id="identifierId")
	private WebElement emailID;
	@FindBy(xpath=".//*[@id='identifierNext']/content/span")
	private WebElement nextButton;
	@FindBy(xpath=".//*[@id='password']/div[1]/div/div[1]/input")
	private WebElement password;
	
	@FindBy(xpath=".//*[@id='passwordNext']/content/span")
	private WebElement pswdNextButton;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInButton()
	{
		WebDriverWait wt= new WebDriverWait(driver,10);
		wt.until(ExpectedConditions.visibilityOf(signInButton));
		signInButton.click();;
	}
	public void enterEmailId(String emailorphone)
	{
		WebDriverWait wt1= new WebDriverWait(driver,10);
		wt1.until(ExpectedConditions.visibilityOf(emailID));
		emailID.clear();
		emailID.sendKeys(emailorphone);
	}
	public void clickOnNext()
	{
		WebDriverWait wt2= new WebDriverWait(driver,10);
		wt2.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
	}
	
	public void enterpswd(String pswd)
	{
		WebDriverWait wt2= new WebDriverWait(driver,10);
		wt2.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(pswd);
	}
	
	public void clickOnPswdNext()
	{
		WebDriverWait wt2= new WebDriverWait(driver,10);
		wt2.until(ExpectedConditions.elementToBeClickable(pswdNextButton));
		pswdNextButton.click();
	}
	
}
