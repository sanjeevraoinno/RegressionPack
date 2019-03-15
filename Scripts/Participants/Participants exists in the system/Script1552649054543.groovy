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

WebUI.mouseOver(findTestObject('Participant Objects/Icon_Organization'))

WebUI.waitForElementPresent(findTestObject('Participant Objects/Icon_Organization'), 1)

'Clicking on Organization icon\r\n'
WebUI.click(findTestObject('Participant Objects/Icon_Organization'))

'Verifying the linktext of Organization \r\n'
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Participant Objects/Organization')), ORG)

println('User is able to navigate to Administration tab')

WebUI.waitForElementVisible(findTestObject('Participant Objects/Link_Participants'), 1)

WebUI.mouseOver(findTestObject('Participant Objects/Link_Participants'), FailureHandling.STOP_ON_FAILURE)

'Clicking on Participants link \r\n'
WebUI.click(findTestObject('Participant Objects/Link_Participants'))

'Verifying the linktext of Participants '
Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Participant Objects/Participants')), Part_txt)

println('User navigated to Participants screen')

'Clicking on advance search icon if given condition gets passed\r\n'
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Advance Search objects/Advanced_searchtext'))) {
    WebUI.click(findTestObject('Object Repository/Advance Search objects/Icon_Advanced Search'))

    println('Performing advance search')
} else {
    println('Failed to perform advance search')
}

'Clicking on fieldname text box\r\n'
WebUI.click(findTestObject('Advance Search objects/FieldName_DropDown'))

WebUI.scrollToElement(findTestObject('Advance Search objects/Option_Participant_id'), 9)

WebUI.click(findTestObject('Advance Search objects/Option_Participant_id'))

'Clicking on comparision text box\r\n'
WebUI.click(findTestObject('Advance Search objects/td_Comparision'))

WebUI.scrollToElement(findTestObject('Advance Search objects/option_Equals'), 2)

'Selecting the equal icon'
WebUI.click(findTestObject('Advance Search objects/option_Equals'))

WebUI.setText(findTestObject('Advance Search objects/td_Value'), PID)

'Clicking on Apply Search button\r\n'
WebUI.click(findTestObject('Advance Search objects/AppySearch_button'))

CustomKeywords.'globalkeywords.record.RecordNotFound'()

