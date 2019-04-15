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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.callTestCase(findTestCase('Unit Types/TC_NavigateUnitTypes'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String HeadingEarningCodes_Expected = WebUI.getText(findTestObject('UnitTypesObjects/Headings_UnitTypes'))

String HeadingEarningCodes_Actual = 'Unit Types'

if (HeadingEarningCodes_Expected.equalsIgnoreCase(HeadingEarningCodes_Actual)) {
    WebUI.click(findTestObject('UnitTypesObjects/Add-Icon'))

    Calendar calendar = Calendar.getInstance()

    String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)

    WebUI.delay(8)

    WebUI.setText(findTestObject('UnitTypesObjects/Input_Name'), 'TF_EUR' + timestamp)

    
	WebUI.click(findTestObject('UnitTypesObjects/BaseUnitTypes_DropDown_Icon'))
    WebUI.setText(findTestObject('UnitTypesObjects/BaseUnitTypes_Dropdown_Menu'), 'Currency')
	
	Robot robot = new Robot()
	robot.keyPress(KeyEvent.VK_ENTER)
	Thread.sleep(2000)
	robot.keyRelease(KeyEvent.VK_ENTER)

    WebUI.click(findTestObject('UnitTypesObjects/Button_Save'))

    log.logPassed('Headings matched....Created Unit Types')
} else {
    log.logFailed('Headings is not matching...test case failed')
}

