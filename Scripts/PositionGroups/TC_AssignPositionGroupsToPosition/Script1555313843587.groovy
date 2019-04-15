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

WebUI.callTestCase(findTestCase('PositionGroups/TC_GeneralSearchPositionGroups'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

String HeadingEarningCodes_Expected = WebUI.getText(findTestObject('PositionGroupsObjects/Headings_PositionGroups'))

String HeadingEarningCodes_Actual = 'Position Groups'

if (HeadingEarningCodes_Expected.equalsIgnoreCase(HeadingEarningCodes_Actual)) {
   WebUI.click(findTestObject('PositionGroupsObjects/Associations_Tab'))
      

    CustomKeywords.'globalkeywords.record.RecordNotFound'()

    log.logPassed('Headings matched....Associations is visible with Positions')
} else {
    log.logFailed('Headings is not matching...test case failed')
}

