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
import org.openqa.selenium.support.ui.Select as Select
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('Rules/TC_NavigateRules'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

WebUI.callTestCase(findTestCase('Rules/TC_SetCalendarRules'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Rules/Deposit Rules/TC_AdvancedSearchDepositRule'), [('vDepositRule') : 'TF_DepositRule_1238'], 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('Object Repository/Rules Objects/Rules_object'))) {
    WebUI.click(findTestObject('Rules Objects/Rules_SelectRow'))

    WebUI.waitForElementClickable(findTestObject('Rules Objects/Icon_EditRules'), 5)

    WebUI.delay(5)

    WebUI.click(findTestObject('Rules Objects/Icon_EditRules'))

    WebUI.waitForElementVisible(findTestObject('Rules Objects/Icon_BURules'), 5)

    WebUI.click(findTestObject('Rules Objects/Icon_BURules'))

    WebUI.mouseOver(findTestObject('Rules Objects/BURules_text'))

    WebUI.waitForElementVisible(findTestObject('Rules Objects/BURules_text'), 5)

    WebUI.click(findTestObject('Rules Objects/BURules_text'))

    WebUI.setText(findTestObject('Rules Objects/BURules_text'), vBUTxt)

    Robot robot = new Robot()

    robot.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    robot.keyRelease(KeyEvent.VK_ENTER)

    WebUI.waitForElementVisible(findTestObject('Rules Objects/Validate_BU'), 5)

    WebUI.click(findTestObject('Object Repository/Rules Objects/Validate_BU'))

    WebUI.click(findTestObject('Rules Objects/Rules_BUsave'))

    WebUI.click(findTestObject('Rules Objects/Close_BU'))

    WebUI.mouseOver(findTestObject('Rules Objects/Credit Rules Objects/button_Save'))

    WebUI.waitForElementVisible(findTestObject('Rules Objects/Credit Rules Objects/button_Save'), 10)

    WebUI.delay(3)

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/button_Save'))

    log.logPassed('Updated Credit Rule')
} else {
    log.logFailed('Not able to Update credit rule ...test case failed')
}

