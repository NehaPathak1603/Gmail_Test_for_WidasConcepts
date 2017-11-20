package script;

import java.awt.AWTException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.HomePage;
import pom.LoginPage;

public class ComposeMailTest extends BaseTest
{
	@Test
	public static void testingcompose() throws InterruptedException, AWTException
	{
		
		String email=Excel.getCellValue("./Data/Input.xlsx", "ComposeTest", 1, 0);
		
		String password=Excel.getCellValue("./Data/Input.xlsx", "ComposeTest", 1, 1);
		
		String to= Excel.getCellValue("./Data/Input.xlsx", "ComposeTest", 1, 2);
		
		String subject= Excel.getCellValue("./Data/Input.xlsx", "ComposeTest", 1, 3);
		
		String body= Excel.getCellValue("./Data/Input.xlsx", "ComposeTest", 1, 4);
		
		
		LoginPage lp= new LoginPage(driver);
		
		//Clicking on signIn
		lp.clickOnSignInButton();
		
		//enter email id
		lp.enterEmailId(email);
		
		//click next
		lp.clickOnNext();
		
		//enter password
		lp.enterpswd(password);
		
		//click login
		lp.clickOnPswdNext();
		
		HomePage hp= new HomePage(driver);
		
		//click on conpose
		hp.clickOnComposeLink();
		
		//enter email in in TO field
		hp.enterTO(to);
		
		//enter subject
		hp.enterSubject(subject);
	    
		//enter mail body
		hp.enterBody(body);
		
        //click on send
		hp.clickOnSubmitButton();
		
		
		Thread.sleep(3000);
		
		//clcik on sent mail and check
		hp.clickOnSentLink();
		
		Thread.sleep(3000);
	}

}
