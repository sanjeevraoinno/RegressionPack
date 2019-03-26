 // Created by: Sanjeev Rao
// Description: Create plan components
// Created date: 20 March 2019
// Modified date: 25 March 2019
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

WebUI.callTestCase(findTestCase('Plan Components/Navigation to Plan Components'), [('PlanComponentName') : 'Aggregated Revenue against Territory based on Flat Rate'
        , ('Plan_data') : 'Plan Data', ('PC_txt') : 'Plan Components'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

// Verifying if the landing page is "Plans" page and creating a Plan accordingly
String Pageheading_Expected = WebUI.getText(findTestObject('Plan Components Objects/PlanComponentsHeading'))

String Pageheading_Actual = 'Plan Components'

if (Pageheading_Expected.equalsIgnoreCase(Pageheading_Actual)) {
    WebUI.click(findTestObject('Plan Components Objects/span_Plan Component Summary_sap-icon-add pointer comm-icon create__usage'))

    WebUI.click(findTestObject('Object Repository/Plans Objects/Okbutton_calendar'))

    Calendar calendar = Calendar.getInstance()

    String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)

    WebUI.setText(findTestObject('Plan Components Objects/input_(Required)_name'), 'TF_PlanComponents_' + timestamp)

    WebUI.setText(findTestObject('Plan Components Objects/input_Description_description'), 'New plan component created')

    WebUI.click(findTestObject('Plan Components Objects/span_This panel is now open for editing_sap-icon-save edit-pane-icon'))

    log.logPassed('On the Plans page and created a Plan')
} else {
    log.logFailed('Not able to find the Plans Heading ...test case failed')
}

