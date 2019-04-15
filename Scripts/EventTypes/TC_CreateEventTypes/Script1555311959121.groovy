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

WebUI.callTestCase(findTestCase('EventTypes/TC_NavigateEventTypes'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String HeadingEarningCodes_Expected = WebUI.getText(findTestObject('EventTypesObjects/Headings_EventTypes'))

String HeadingEarningCodes_Actual = 'Event Types'

if (HeadingEarningCodes_Expected.equalsIgnoreCase(HeadingEarningCodes_Actual)) {
	WebUI.click(findTestObject('EventTypesObjects/Add_Icon'))

	Calendar calendar = Calendar.getInstance()

	String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)

	WebUI.setText(findTestObject('EventTypesObjects/Input_ID'), 'TF_EventTypes' + timestamp)

	WebUI.setText(findTestObject('EventTypesObjects/Input_Des'), 'EventTypes_desc')

	WebUI.click(findTestObject('EventTypesObjects/Button_Save'))

	log.logPassed('Headings matched....Created EventTypes')
} else {
	log.logFailed('Headings is not matching...test case failed')
}

