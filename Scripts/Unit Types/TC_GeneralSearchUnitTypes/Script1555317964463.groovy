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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('Unit Types/TC_NavigateUnitTypes'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String HeadingEarningCodes_Expected = WebUI.getText(findTestObject('UnitTypesObjects/Headings_UnitTypes'))

String HeadingEarningCodes_Actual = 'Unit Types'

if (HeadingEarningCodes_Expected.equalsIgnoreCase(HeadingEarningCodes_Actual)) {
    WebUI.click(findTestObject('UnitTypesObjects/General Search Icon'))

    WebUI.click(findTestObject('UnitTypesObjects/General Search_Textbox'))

    WebUI.setText(findTestObject('UnitTypesObjects/General Search_Textbox'), 'TF_EUR1351044')

    WebUI.click(findTestObject('UnitTypesObjects/General Search Icon'))

    CustomKeywords.'globalkeywords.record.RecordNotFound'()

    log.logPassed('Headings matched....Unit Types ID is visible')
} else {
    log.logFailed('Headings is not matching...test case failed')
}

