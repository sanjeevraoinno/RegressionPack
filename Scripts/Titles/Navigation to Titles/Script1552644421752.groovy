import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.testng.Assert as Assert

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/Commission Login'), [('header_name') : 'Sales Performance Home '
        , ('Manager_org') : 'Manage Organization'], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Titles Objects/Icon_Organization'))

WebUI.waitForElementPresent(findTestObject('Titles Objects/Icon_Organization'), 1)

'Clicking on Organization icon\r\n'
WebUI.click(findTestObject('Titles Objects/Icon_Organization'))

'Verifying the linktext of Organization\r\n'
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Titles Objects/Organization')), ORG)

println('User is able to navigate to Administration tab')

WebUI.waitForElementVisible(findTestObject('Titles Objects/Link_Titles'), 4)

WebUI.mouseOver(findTestObject('Titles Objects/Link_Titles'), FailureHandling.STOP_ON_FAILURE)

'Clicking on Titles link\r\n\r\n'
WebUI.click(findTestObject('Titles Objects/Link_Titles'))

'Verifying the linktext of Titles\r\n'
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Titles Objects/Titles')), Titletxt)

println('User navigated to Titles screen')

