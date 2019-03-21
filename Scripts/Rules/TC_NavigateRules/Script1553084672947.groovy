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

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/TC_CommissionLoginPage'), [('vHeader_Name') : 'Sales Performance Home '
        , ('vManager_Org') : 'Manage Organization'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

//Verifying the availability of "Manage Plans" text, if it matches clicking on the Plan link
String ManagePlans_Expected = WebUI.getText(findTestObject('Object Repository/Plans Objects/ManagePlansText'))

String ManagePlans_ActualText = 'Manage Plans'

if (ManagePlans_Expected.equalsIgnoreCase(ManagePlans_ActualText)) {
    WebUI.click(findTestObject('Object Repository/Rules Objects/Credit Rules Objects/Icon_PlanData'))

    WebUI.click(findTestObject('Object Repository/Rules Objects/Credit Rules Objects/Link_Rules'))

    log.logPassed('On the Manage Plans Rules')
} else {
    log.logFailed('Not able to find the Manage Plans Rules ...test case failed')
}
