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
import org.junit.After as After
import org.testng.Assert as Assert

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/Commission Login'), [('header_name') : 'Sales Performance Home '
        , ('Manager_org') : 'Manage Organization'], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Plan Components Objects/Icon_PlanData'))

WebUI.waitForElementPresent(findTestObject('Plan Components Objects/Icon_PlanData'), 2)

'Clicking on Plan data icon\r\n'
WebUI.click(findTestObject('Plan Components Objects/Icon_PlanData'))

'Verifying the link text'
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Plan Components Objects/Plan data')), Plan_data)

println('User is able to navigate to Plan tab')

WebUI.waitForElementVisible(findTestObject('Plan Components Objects/Link_Plan Components'), 1)

WebUI.mouseOver(findTestObject('Plan Components Objects/Link_Plan Components'), FailureHandling.STOP_ON_FAILURE)

'Clicking on the Plan Component link\r\n'
WebUI.click(findTestObject('Plan Components Objects/Link_Plan Components'))

'Verifying the linktext of Plan Component\r\n'
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Plan Components Objects/Plan Component')), PC_txt)

println('User navigated to Plan Components screen')

