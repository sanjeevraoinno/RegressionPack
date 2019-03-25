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
import io.cucumber.tagexpressions.TagExpressionParser.True as True
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('Participants/TC_SetCalendarParticpant'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)
KeywordLogger log = new KeywordLogger()
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Participant Objects/Add_NewParticipant'))) {
    WebUI.click(findTestObject('Participant Objects/Add_Participant'))

    

    WebUI.click(findTestObject('Participant Objects/Calendar_Period_participant'))

    WebUI.setText(findTestObject('Participant Objects/Set_Start Calendar'), vParticipantCalendar)

    Robot robot = new Robot()

    robot.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    robot.keyRelease(KeyEvent.VK_ENTER)

    WebUI.click(findTestObject('Participant Objects/span_Ok'))

    Calendar calendar = Calendar.getInstance()

    String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)

    WebUI.setText(findTestObject('Participant Objects/input_(Required)_payeeId'), 'TF_Participant_' + timestamp)

    //WebUI.setText(findTestObject('Participant Objects/input_(Required)_payeeId'), vPayeeId)
    WebUI.click(findTestObject('Participant Objects/input_Prefix_prefix'))

    WebUI.setText(findTestObject('Participant Objects/input_Prefix_prefix'), vPrefix)

    WebUI.click(findTestObject('Participant Objects/input_First Name_firstName'))

    WebUI.setText(findTestObject('Participant Objects/input_First Name_firstName'), vFirstName)

    WebUI.click(findTestObject('Participant Objects/input_(Required)_lastName'))

    WebUI.setText(findTestObject('Participant Objects/input_(Required)_lastName'), vLastName)

    WebUI.click(findTestObject('Participant Objects/Icon_Save'))

    String vAddParticipant_Expected = WebUI.verifyElementClickable(findTestObject('Object Repository/Participant Objects/Icon_Save'))

    if (vAddParticipant_Expected == true) {
        WebUI.click(findTestObject('Participant Objects/Icon_Save'))

        log.logPassed('Save button is clicked')

        log.logPassed('Participant got created')
    } else {
        log.logFailed('Failed to click save button')
    }
} else {
    log.logFailed('Failed to create participant')
}

