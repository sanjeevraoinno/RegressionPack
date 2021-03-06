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

WebUI.callTestCase(findTestCase('Plans/Navigation to Plan'), [('Plan_data') : 'Plan Data', ('Plan_txt') : 'Plans'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(5)

WebUI.scrollToPosition(0, 0)

'Clicking on advance search icon if given condition gets passed\r\n'
if (WebUI.verifyElementClickable(findTestObject('Advanced Search objects/Advanced_searchtext'))) {
    WebUI.click(findTestObject('Advanced Search objects/Icon_Advanced Search'))

    println('Performing advance search')
} else {
    println('Failed to perform advance search')
}

'Clicking on fieldname text box\r\n'
WebUI.waitForElementVisible(findTestObject('Advanced Search objects/FieldName_DropDown'), 2)

WebUI.click(findTestObject('Advanced Search objects/FieldName_DropDown'))

WebUI.scrollToElement(findTestObject('Advanced Search objects/option_Value'), 4)

WebUI.waitForElementClickable(findTestObject('Advanced Search objects/option_Value'), 2)

WebUI.click(findTestObject('Advanced Search objects/option_Value'))

'Clicking on comparision text box\r\n'
WebUI.click(findTestObject('Advanced Search objects/td_Comparision'))

WebUI.waitForElementVisible(findTestObject('Advanced Search objects/option_Equals'), 2)

WebUI.scrollToElement(findTestObject('Advanced Search objects/option_Equals'), 2)

WebUI.waitForElementClickable(findTestObject('Advanced Search objects/option_Equals'), 2)

'Selecting the equal icon \r\n'
WebUI.click(findTestObject('Advanced Search objects/option_Equals'))

WebUI.waitForElementClickable(findTestObject('Advanced Search objects/td_Value'), 5)

WebUI.click(findTestObject('Advanced Search objects/td_Value'))

WebUI.setText(findTestObject('Advanced Search objects/td_Value'), SerachString)

WebUI.waitForElementClickable(findTestObject('Advanced Search objects/AppySearch_button'), 2)

WebUI.click(findTestObject('Advanced Search objects/AppySearch_button'))

CustomKeywords.'globalkeywords.record.RecordNotFound'()

