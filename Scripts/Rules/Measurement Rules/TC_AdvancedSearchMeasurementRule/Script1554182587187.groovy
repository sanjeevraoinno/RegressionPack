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

WebUI.callTestCase(findTestCase('Rules/TC_NavigateRules'), [:], FailureHandling.STOP_ON_FAILURE)

'Clicking on advance search icon if given condition gets passed\r\n'
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Advanced Search objects/Advanced_searchtext'))) {
    WebUI.click(findTestObject('Advanced Search objects/Icon_Advanced Search'))

    WebUI.delay(5)

    WebUI.selectOptionByIndex(findTestObject('Advanced Search objects/FieldName_DropDown'), 3)

    'Clicking on comparision text box\r\n'
    WebUI.click(findTestObject('Advanced Search objects/td_Comparision'))

    WebUI.scrollToElement(findTestObject('Advanced Search objects/option_Equals'), 2)

    'Selecting the equal icon\r\n'
    WebUI.click(findTestObject('Advanced Search objects/option_Equals'))

    WebUI.setText(findTestObject('Advanced Search objects/td_Value'), vMeasurementRule)

    'Clicking on Apply Search button\r\n'
    WebUI.click(findTestObject('Advanced Search objects/AppySearch_button'))
} else {
    println('Failed to perform advance search')
}

CustomKeywords.'globalkeywords.record.RecordNotFound'()

