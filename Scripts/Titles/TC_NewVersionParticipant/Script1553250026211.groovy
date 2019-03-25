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

WebUI.callTestCase(findTestCase('Participants/TC_NavigateParticipant'), [('vOrg') : 'Organization', ('vParticipantText') : 'Participants'], 
    FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String Participant_Expected = WebUI.getText(findTestObject('Object Repository/Participant Objects/ParticipantSummary'))

String Participant_ActualText = 'Participant Summary'

if (Participant_Expected.equalsIgnoreCase(Participant_ActualText)) {
    WebUI.click(findTestObject('Participant Objects/Manage Version'))

    WebUI.waitForElementVisible(findTestObject('Participant Objects/Create Version'), 10)

    WebUI.click(findTestObject('Participant Objects/Create Version'))

    WebUI.click(findTestObject('Participant Objects/Calendar_Period_participant'))

    WebUI.setText(findTestObject('Participant Objects/Version Textbox'), vEffectiveDate)
	Robot robot = new Robot()
	
		robot.keyPress(KeyEvent.VK_ENTER)
	
		Thread.sleep(2000)
	
		robot.keyRelease(KeyEvent.VK_ENTER)
	
	
    WebUI.click(findTestObject('Participant Objects/VersionEffective_ok'))

    WebUI.click(findTestObject('Participant Objects/span_Ok'))

    log.logPassed('On the Particiapnt workspace')
} else {
    log.logFailed('Not able create version for participant ...test case failed')
}

