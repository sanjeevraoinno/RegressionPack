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
import org.junit.After as After
import org.testng.Assert as Assert
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('Participants/TC_NavigateParticipant'), [('vOrg') : 'Organization', ('vParticipantText') : 'Participants'], 
    FailureHandling.STOP_ON_FAILURE)

'Clicking on advance search icon if given condition gets passed\r\n'
if (WebUI.verifyElementClickable(findTestObject('Advanced Search objects/Advanced_searchtext'))) {
    WebUI.click(findTestObject('Advanced Search objects/Icon_Advanced Search'))

    KeywordLogger log = new KeywordLogger()

    'Clicking on fieldname text box\r\n'
    WebUI.click(findTestObject('Advanced Search objects/FieldName_DropDown'))

    WebUI.scrollToElement(findTestObject('Advanced Search objects/Option_Participant_id'), 9)

    WebUI.click(findTestObject('Advanced Search objects/Option_Participant_id'))

    'Clicking on comparision text box\r\n'
    WebUI.click(findTestObject('Advanced Search objects/td_Comparision'))

    WebUI.scrollToElement(findTestObject('Advanced Search objects/option_Equals'), 2)

    'Selecting the equal icon'
    WebUI.click(findTestObject('Advanced Search objects/option_Equals'))

    WebUI.setText(findTestObject('Advanced Search objects/td_Value'), vPid)

    // String vApplysearch_Expected = WebUI.verifyElementClickable(findTestObject('Object Repository/Advanced Search objects/AppySearch_button'))
    //if (vApplysearch_Expected == true) {
    WebUI.click(findTestObject('Object Repository/Advanced Search objects/AppySearch_button'))

    //  log.logPassed('Apply search button is clicked')
    log.logPassed('Advanced search is performed' //} 
        ) //else {
    //log.logFailed('Failed to click Apply search button')
    //}
} else {
    log.logFailed('Failed to performe advanced search')
}

CustomKeywords.'globalkeywords.record.RecordNotFound'()

