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

WebUI.callTestCase(findTestCase('Participants/TC_SetCalendarParticpant'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Participants/TC_AdvancedSearchParticipant'), [('vPid') : 'TF_Plan_127', ('vOrg') : 'Organization'
        , ('vParticipantText') : 'Participants'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

WebUI.scrollToPosition(1, 0)

String Version_Expected = WebUI.getText(findTestObject('Object Repository/Participant Objects/ParticipantSummary'))

String Version_Actual = 'Participant Summary'

if(Version_Expected.equalsIgnoreCase(Version_Actual))
{

WebUI.click(findTestObject('Participant Objects/Manage Version'))

WebUI.waitForElementClickable(findTestObject('Participant Objects/Create Version'), 5)

WebUI.doubleClick(findTestObject('Participant Objects/Create Version'))

WebUI.click(findTestObject('Participant Objects/Calendar_Period_participant'))

WebUI.setText(findTestObject('Participant Objects/Version Textbox'), vVersionCalendar)

Robot robot = new Robot()

robot.keyPress(KeyEvent.VK_ENTER)

Thread.sleep(2000)

robot.keyRelease(KeyEvent.VK_ENTER)

WebUI.click(findTestObject('Participant Objects/VersionEffective_ok'))

WebUI.click(findTestObject('Participant Objects/Popup_yes button'))

WebUI.click(findTestObject('Participant Objects/span_Ok'))

KeywordUtil.markPassed('Created version for Participant')

} else {

KeywordUtil.markFailed('Failed to create version for Participant')

}

