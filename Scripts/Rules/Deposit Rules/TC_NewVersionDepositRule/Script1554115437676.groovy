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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Rules/TC_NavigateRules'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

WebUI.callTestCase(findTestCase('Rules/TC_SetCalendarRules'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Rules/Deposit Rules/TC_AdvancedSearchDepositRule'), [('vDepositRule') : 'TF_DepositRule_1722'], 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('Object Repository/Rules Objects/Rules_object'))) {
    WebUI.check(findTestObject('Rules Objects/Rules_checkbox'))

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/button_Create New_Version'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/select_Create New Version'))

    WebUI.scrollToElement(findTestObject('Rules Objects/Credit Rules Objects/option_NewVersion'), 1)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/option_NewVersion'))

    WebUI.click(findTestObject('Participant Objects/Calendar_Period_participant'))

    WebUI.waitForElementClickable(findTestObject('Participant Objects/Version Textbox'), 5)

    WebUI.setText(findTestObject('Participant Objects/Version Textbox'), vDepositCalendar)

    Robot robot = new Robot()

    robot.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    robot.keyRelease(KeyEvent.VK_ENTER)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/Version_Effective_ok_rules'))

    WebUI.click(findTestObject('Participant Objects/Popup_yes button'))

    WebUI.waitForElementClickable(findTestObject('Rules Objects/Credit Rules Objects/button_Save'), 10)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/button_Save'))

    log.logPassed('New Version for Credit Rule')
} else {
    log.logFailed('Not able to Create New version for credit rule ...test case failed')
}

