import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.testng.Assert as Assert

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

//User can verify that whether login page has loaded or not  
'Verifying login page has loaded correctly\r\n'
boolean result = Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Login_Navigation_Logout Objects/Header_homepage')), 
    header_name)

//if (result == true)
//{

'Providing the Username'
WebUI.setText(findTestObject('Login_Navigation_Logout Objects/input_Username_username'), GlobalVariable.Username)

'Password to be provided in the text box'
WebUI.setText(findTestObject('Login_Navigation_Logout Objects/input_Password_password'), GlobalVariable.Password)

WebUI.waitForElementClickable(findTestObject('Login_Navigation_Logout Objects/Login_Button'), 2)

'Clicking  the submit button '
WebUI.click(findTestObject('Login_Navigation_Logout Objects/Login_Button'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Login_Navigation_Logout Objects/Icon_Apps'))

WebUI.mouseOver(findTestObject('Login_Navigation_Logout Objects/Link_Commissions'))

WebUI.scrollToElement(findTestObject('Login_Navigation_Logout Objects/Link_Commissions'), 1)

'Clicking on Commissions link \r\n'
WebUI.click(findTestObject('Login_Navigation_Logout Objects/Link_Commissions'))

'Verifying the Username'

/*WebUI.click(findTestObject('Login_Navigation_Logout Objects/User_id'))

WebUI.waitForElementVisible(findTestObject('Login_Navigation_Logout Objects/user_name'), 1)
*/
'Verifying Commissions has loaded correctly'
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Login_Navigation_Logout Objects/Manage_Organization')), 
    Manager_org)

WebUI.waitForPageLoad(3)

//}

/*else{
	
 System.out.print("Unable to launch the login page")
	
}*/


