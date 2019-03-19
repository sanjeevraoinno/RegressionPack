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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Participants/TC_SetCalendarParticpant'), [('Txt_calendar') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Participants/TC_AdvancedSearchParticipant'), [('PID') : 'Vishnu1', ('ORG') : 'Organization'
        , ('Part_txt') : 'Participants'], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToPosition(1, 0)

if (WebUI.verifyElementClickable(findTestObject('Participant Objects/Delete_Participant'))) {
    WebUI.click(findTestObject('Participant Objects/Delete_Participant'))

    KeywordUtil.markPassed('Deleted Participant')
} else {
      KeywordUtil.markFailed('Failed to delete Participant')

}

