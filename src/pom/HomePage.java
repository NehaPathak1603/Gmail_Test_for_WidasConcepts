package pom;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;


public class HomePage extends BasePage
{

	@FindBy(xpath="//div[text()='COMPOSE']")
	private WebElement composeLink;
	
	@FindBy(xpath="//a[text()='Sent Mail']")
	private WebElement sentLink;
	
	@FindBy(xpath="//a[contains(text(),'Drafts')]")
	private WebElement draftLink;
	
	@FindBy(xpath=".//*[@aria-label='To']")
	private WebElement to;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	private WebElement subject;
	
	@FindBy(xpath="//div[@class='Am Al editable LW-avf']")
	private WebElement msgcontent;	
	
	@FindBy(xpath=".//*[text()='Send']")
	private WebElement submitButton;
	
	@FindBy(xpath="//span[text()='drafttest']")
	private WebElement draftsubjectValidate;
	
	@FindBy(xpath=".//*[@data-tooltip='Save & Close']")
	private WebElement closeButton;
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnComposeLink()
	{
		WebDriverWait wt= new WebDriverWait(driver,20);
		wt.until(ExpectedConditions.visibilityOf(composeLink));
		composeLink.click();
	}
	public void enterTO(String email) 
	{
		
		WebDriverWait wt1= new WebDriverWait(driver,10);
		wt1.until(ExpectedConditions.visibilityOf(to));
		to.click();
		to.sendKeys(email);
		
	}
	
	public void enterSubject(String subj)
	{
		WebDriverWait wt2= new WebDriverWait(driver,10);
		wt2.until(ExpectedConditions.visibilityOf(subject));
		subject.sendKeys(subj);
	}
	
	public void enterBody(String content)
	{
		WebDriverWait wt3= new WebDriverWait(driver,10);
		wt3.until(ExpectedConditions.visibilityOf(msgcontent));
		msgcontent.sendKeys(content);
	}
	
	public void clickOnSubmitButton() throws AWTException
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void clickOnSentLink()
	{
		WebDriverWait wt4= new WebDriverWait(driver,10);
		wt4.until(ExpectedConditions.visibilityOf(sentLink));
		sentLink.click();
	}
	

	public void clickOnCloseButton()
	{
		WebDriverWait wt= new WebDriverWait(driver,10);
		wt.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}
	
	public void clickOnDraftLink()
	{
		WebDriverWait wt4= new WebDriverWait(driver,10);
		wt4.until(ExpectedConditions.visibilityOf(draftLink));
		draftLink.click();
	}
	
	public void validatingDraftMail(String expectedSubject)
	{
		WebDriverWait wt4= new WebDriverWait(driver,20);
		wt4.until(ExpectedConditions.visibilityOf(draftsubjectValidate));
		String actualSubject = draftsubjectValidate.getText();
		assertEquals(actualSubject, expectedSubject, "fail");
	}
	
}

