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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('Rules/TC_NavigateRules'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementClickable(findTestObject('General search Objects/Gerneral search textbox'))) {
    WebUI.waitForElementClickable(findTestObject('General search Objects/Gerneral search textbox'), 100)

    WebUI.click(findTestObject('General search Objects/General_search_icon'))

    WebUI.click(findTestObject('General search Objects/Gerneral search textbox'))

    WebUI.setText(findTestObject('General search Objects/Gerneral search textbox'), vCreditRule)

    WebUI.click(findTestObject('General search Objects/General_search_icon'))

    KeywordUtil.markPassed('credit rule is visible')
} else {
    KeywordUtil.markFailed('credit rule  is not visible')
}

CustomKeywords.'globalkeywords.record.RecordNotFound'()

