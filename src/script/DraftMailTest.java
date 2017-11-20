package script;

import java.awt.AWTException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.HomePage;
import pom.LoginPage;

public class DraftMailTest extends BaseTest
{
	@Test
	public static void testingDraftMail() throws InterruptedException, AWTException
	{
        String email=Excel.getCellValue("./Data/Input.xlsx", "DraftTest", 1, 0);
		
		String password=Excel.getCellValue("./Data/Input.xlsx", "DraftTest", 1, 1);
		
		String to= Excel.getCellValue("./Data/Input.xlsx", "DraftTest", 1, 2);
		
		String subject= Excel.getCellValue("./Data/Input.xlsx", "DraftTest", 1, 3);
		
		String body= Excel.getCellValue("./Data/Input.xlsx", "DraftTest", 1, 4);
		
		
		LoginPage lp= new LoginPage(driver);
		
		//Clicking on signIn
		lp.clickOnSignInButton();
		
        //enter emaail id
		lp.enterEmailId(email);
		
		//click on next
		lp.clickOnNext();
		
		//enter password
		lp.enterpswd(password);
		
		//clcik on login
		lp.clickOnPswdNext();
		
		HomePage hp= new HomePage(driver);
		
		//click on compose
		hp.clickOnComposeLink();
		
		//enter email id in TO field
		hp.enterTO(to);
		
		//enter subject
		hp.enterSubject(subject);
	
		//enter mail body
		hp.enterBody(body);
		
		//click on submit
		hp.clickOnCloseButton();
		
		//clcik on draft 
        hp.clickOnDraftLink();
		
        //validate the drafted mail
		hp.validatingDraftMail(subject);
		
		
	}
}
