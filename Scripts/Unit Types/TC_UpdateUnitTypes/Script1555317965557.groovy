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

WebUI.callTestCase(findTestCase('Unit Types/TC_GeneralSearchUnitTypes'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String HeadingEarningCodes_Expected = WebUI.getText(findTestObject('UnitTypesObjects/Headings_UnitTypes'))

String HeadingEarningCodes_Actual = 'Unit Types'

if (HeadingEarningCodes_Expected.equalsIgnoreCase(HeadingEarningCodes_Actual)) {
    WebUI.click(findTestObject('UnitTypesObjects/Edit_Icon'))

    Calendar calendar = Calendar.getInstance()

    String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)

    WebUI.delay(10)

    WebUI.clearText(findTestObject('UnitTypesObjects/Input_Name'))

    WebUI.setText(findTestObject('UnitTypesObjects/Input_Name'), 'TF_EUR' + timestamp)

    WebUI.clearText(findTestObject('ReasonCodesObjects/Input_Des'))

    WebUI.setText(findTestObject('UnitTypesObjects/Input_Des'), 'The euro is the official currency of 19 of the 28 member states of the European Union.')

    WebUI.click(findTestObject('UnitTypesObjects/Button_Save'))

    log.logPassed('Headings matched....Updated Unit Types')
} else {
    log.logFailed('Headings is not matching...test case failed')
}

