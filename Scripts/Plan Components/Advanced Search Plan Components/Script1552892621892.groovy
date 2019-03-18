import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.junit.After as After
import org.testng.Assert as Assert

WebUI.callTestCase(findTestCase('Plan Components/Navigation to Plan Components'), [('PlanComponentName') : 'Aggregated Revenue against Territory based on Flat Rate'
        , ('Plan_data') : 'Plan Data', ('PC_txt') : 'Plan Components'], FailureHandling.STOP_ON_FAILURE)

'Clicking on advance search icon if given condition gets passed\r\n\r\n'
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Advance Search objects/Advanced_searchtext'))) {
    WebUI.click(findTestObject('Object Repository/Advance Search objects/Icon_Advanced Search'))

    println('Performing advance search')
} else {
    println('Failed to perform advance search')
}

'Clicking on fieldname text box\r\n'
WebUI.click(findTestObject('Advance Search objects/FieldName_DropDown'))

WebUI.scrollToElement(findTestObject('Advance Search objects/option_Value'), 4)

WebUI.click(findTestObject('Advance Search objects/option_Value'))

'Clicking on comparision text box\r\n'
WebUI.click(findTestObject('Advance Search objects/td_Comparision'))

WebUI.scrollToElement(findTestObject('Advance Search objects/option_Equals'), 2)

'Selecting the equal icon\r\n'
WebUI.click(findTestObject('Advance Search objects/option_Equals'))

WebUI.setText(findTestObject('Advance Search objects/td_Value'), PlanComponentName)

'Clicking on Apply Search button'
WebUI.click(findTestObject('Advance Search objects/AppySearch_button'))

CustomKeywords.'globalkeywords.record.RecordNotFound'()

