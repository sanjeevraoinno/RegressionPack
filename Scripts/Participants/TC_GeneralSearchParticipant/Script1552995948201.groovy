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
import com.kms.katalon.core.util.KeywordUtil


WebUI.callTestCase(findTestCase('Participants/TC_NavigateParticipant'), [('PID') : 'Payee01', ('ORG') : 'Organization'
        , ('Part_txt') : 'Participants'], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementClickable(findTestObject('Object Repository/Participant Objects/Gerneral search textbox'))) {
    WebUI.waitForElementClickable(findTestObject('Object Repository/Participant Objects/Gerneral search textbox'), 100)

    WebUI.click(findTestObject('Object Repository/Participant Objects/General_search_icon'))

    WebUI.click(findTestObject('Object Repository/Participant Objects/Gerneral search textbox'))

    WebUI.setText(findTestObject('Object Repository/Participant Objects/Gerneral search textbox'), vParticipantId)
	  
	WebUI.click(findTestObject('Object Repository/Participant Objects/General_search_icon'))
	
	KeywordUtil.markPassed('Participant is visible')
  	
} else {

KeywordUtil.markFailed("Participant  is not visible")

}



CustomKeywords.'globalkeywords.record.RecordNotFound'()

