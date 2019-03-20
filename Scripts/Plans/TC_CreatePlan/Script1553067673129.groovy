 // Created by: 
// Description: 
// Created date:
// Modified date:
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
import org.testng.Assert as Assert
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('Plans/TC_NavigatePlan'), [('Plan_data') : 'Plan Data', ('Plan_txt') : 'Plans'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()


// Verifying if the landing page is "Plans" page and creating a Plan accordingly
String Pageheading_Expected = WebUI.getText(findTestObject('Object Repository/Plans Objects/PlansHeading'))

String Pageheading_Actual = 'Plans'

if (Pageheading_Expected.equalsIgnoreCase(Pageheading_Actual)) {
    WebUI.click(findTestObject('Object Repository/Plans Objects/CreateNew_link'))

    WebUI.click(findTestObject('Object Repository/Plans Objects/Okbutton_calendar'))

    Calendar calendar = Calendar.getInstance()

    String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + ':') + calendar.get(Calendar.MINUTE)

    WebUI.setText(findTestObject('Object Repository/Plans Objects/Input_Name'), 'TF_Plan_' + timestamp)

    WebUI.setText(findTestObject('Object Repository/Plans Objects/Input_Description'), 'New plan created')

    WebUI.click(findTestObject('Object Repository/Plans Objects/Save_button'))

    log.logPassed('On the Plans page and created a Plan')
} else {
    log.logFailed('Not able to find the Plans Heading ...test case failed')
}

