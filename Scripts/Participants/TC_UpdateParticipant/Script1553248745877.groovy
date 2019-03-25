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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('Participants/TC_SetCalendarParticpant'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Participants/TC_AdvancedSearchParticipant'), [('vPid') : 'TF_Plan_127', ('vOrg') : 'Organization'
        , ('vParticipantText') : 'Participants'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()


String updated_excepted = WebUI.getText(findTestObject('Object Repository/Participant Objects/ParticipantDetails'))
String updated_Actual ='Participant Details'

if (updated_excepted.equalsIgnoreCase(updated_Actual)) {
    WebUI.click(findTestObject('Participant Objects/Update participant'))

    WebUI.waitForElementClickable(findTestObject('Participant Objects/Input_suffix'), 5)

    WebUI.doubleClick(findTestObject('Object Repository/Participant Objects/Input_suffix'))

    WebUI.setText(findTestObject('Object Repository/Participant Objects/Input_suffix'), vUpdatePart)

    WebUI.click(findTestObject('Object Repository/Participant Objects/Icon_Save'))
	
	KeywordUtil.markPassed('Updated Participant')
	
} else {

KeywordUtil.markFailed('Failed to Update Participant')

}

