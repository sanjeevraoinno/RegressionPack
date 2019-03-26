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

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/TC_CommissionLoginPage'), [('vHeader_Name') : 'Sales Performance Home '
        , ('vManager_Org') : 'Manage Organization'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String ManagePlans_Expected = WebUI.getText(findTestObject('Object Repository/Plans Objects/ManagePlansText'))

String ManagePlans_ActualText = 'Manage Plans'

if (ManagePlans_Expected.equalsIgnoreCase(ManagePlans_ActualText)) {
    WebUI.click(findTestObject('Object Repository/Rules Objects/Credit Rules Objects/Icon_PlanData'))

    WebUI.click(findTestObject('Object Repository/Rules Objects/Credit Rules Objects/Link_Rules'))

    log.logPassed('On the Manage Plans Rules')
} else {
    log.logFailed('Not able to find the Manage Plans Rules ...test case failed')
}

String ruleExpected = WebUI.getWindowTitle()

String ruleActual = 'Rules'

if (ruleExpected.equalsIgnoreCase(ruleActual)) {
    WebUI.callTestCase(findTestCase('Rules/TC_SetCalendarRules'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/Create_rule'))

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/span_Credit Rule'))

    WebUI.waitForElementVisible(findTestObject('Rules Objects/Credit Rules Objects/select Rule_dropdown'), 10)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/select Rule_dropdown'))

    WebUI.setText(findTestObject('Rules Objects/Credit Rules Objects/select Rule_dropdown'), vCreditrule)

    Robot robot = new Robot()

    robot.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    robot.keyRelease(KeyEvent.VK_ENTER)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/Calendar_Rules'))

    WebUI.setText(findTestObject('Rules Objects/Credit Rules Objects/Set Calendar_rules'), vCalendar)

    Robot robot1 = new Robot()

    robot1.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    robot1.keyRelease(KeyEvent.VK_ENTER)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/span_Ok'))

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/input_Name_ruleName'))

    Calendar calendar = Calendar.getInstance()

    String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)

    WebUI.setText(findTestObject('Participant Objects/input_(Required)_payeeId'), 'TF_CreditRule_' + timestamp)

    WebUI.scrollToPosition(1, 1)

    WebUI.mouseOver(findTestObject('Rules Objects/Credit Rules Objects/Event Type_choices'))

    WebUI.waitForElementClickable(findTestObject('Rules Objects/Credit Rules Objects/Event Type_choices'), 5)

    WebUI.doubleClick(findTestObject('Rules Objects/Credit Rules Objects/Event Type_choices'))

    WebUI.setText(findTestObject('Rules Objects/Credit Rules Objects/Event Type_choices'), vEventType)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/button_Save'))

    log.logPassed('Created Credit Rule')
} else {
    log.logFailed('Not able to Create credit rule ...test case failed')
}

