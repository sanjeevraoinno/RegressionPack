import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Titles/TC_NavigationToTitles'), [('TitleName') : 'Title_9', ('ORG') : 'Organization', ('Titletxt') : 'Titles'], 
    FailureHandling.STOP_ON_FAILURE)

boolean gSearchicon = WebUI.verifyElementVisible(findTestObject('Titles Objects/General_search_icon'))

if (gSearchicon) {
    WebUI.waitForElementClickable(findTestObject('Titles Objects/General_search_icon'), 15)

    WebUI.click(findTestObject('Titles Objects/General_search_icon'))

    WebUI.click(findTestObject('Titles Objects/Gerneral_search_textbox'))

    WebUI.setText(findTestObject('Titles Objects/Gerneral_search_textbox'), titleName)

    WebUI.click(findTestObject('Titles Objects/General_search_icon'))

    CustomKeywords.'globalkeywords.record.RecordNotFound'()
} else {
    KeywordUtil.markFailed('Unable to find the General Searchbox')
}

