package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class BasePage 
{
	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
		public void verifyTitle(String eTitle)
		{
			try 
			{
				WebDriverWait wait=new WebDriverWait(driver,5);
				wait.until(ExpectedConditions.titleIs(eTitle));
				Reporter.log("PASS:title matched",true);
			} catch (Exception e) 
			{
				Reporter.log("FAIL:title not mathed",true);
			}
		}
	

}
