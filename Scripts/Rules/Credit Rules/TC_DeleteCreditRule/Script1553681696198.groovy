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

WebUI.callTestCase(findTestCase('Rules/TC_NavigateRules'), [:], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

WebUI.callTestCase(findTestCase('Rules/TC_SetCalendarRules'), [('vCalendarText') : 'January 2018'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Rules/Credit Rules/TC_AdvancedSearchCreditRule'), [('vRuleName') : 'TF_CreditRule_1058'], 
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('Object Repository/Rules Objects/Rules_object'))) {
    WebUI.check(findTestObject('Rules Objects/input_Checkbox_Rules'))

    WebUI.click(findTestObject('Rules Objects/Credit Rules Objects/button_Create New_adv_rule_del_btn'))

    log.logPassed('Deleted Credit Rule')
} else {
    log.logFailed('Not able to Delete credit rule ...test case failed')
}

