 // Created by: Shiva
// Description: Advanced Search of Position
// Created date: 3/23/2019
// Modified date: 4/5/2019 --> passing the dyamic created string for search.
 
 /**
  * Note: Plese run this test case in the suit, it takes the dynamic search string of position.
  * It searches the position which created useing  time stamp.
  */
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

WebUI.callTestCase(findTestCase('Positions/TC_NavigationToPositions'), [('PositionName') : 'Title_9', ('ORG') : 'Organization'
        , ('Positiontxt') : 'Positions'], FailureHandling.STOP_ON_FAILURE)

'Clicking on advance search icon if given condition gets passed\r\n'
if (WebUI.verifyElementClickable(findTestObject('Object Repository/Advanced Search objects/Advanced_searchtext'))) {
    WebUI.waitForElementClickable(findTestObject('Advanced Search objects/Icon_Advanced Search'), 5)

    WebUI.click(findTestObject('Object Repository/Advanced Search objects/Icon_Advanced Search'))

    println('Performing advance search')
} else {
    println('Failed to perform advance search')
}

'Clicking on fieldname text box\r\n'
WebUI.click(findTestObject('Advanced Search objects/FieldName_DropDown'))

WebUI.scrollToElement(findTestObject('Advanced Search objects/option_Value'), 4)

WebUI.click(findTestObject('Advanced Search objects/option_Value'))

'Clicking on comparision text box\r\n'
WebUI.click(findTestObject('Advanced Search objects/td_Comparision'))

WebUI.scrollToElement(findTestObject('Advanced Search objects/option_Equals'), 2)

'Selecting the equal icon\r\n'
WebUI.click(findTestObject('Advanced Search objects/option_Equals'))

//('XXXXXXXXXXXXXXXXXXX' + GlobalVariable.PositionAdvanceSearch)

//use Position for test single test case:  TF_Position_190410_085315


WebUI.setText(findTestObject('Advanced Search objects/td_Value'), GlobalVariable.PositionAdvanceSearch)

//println('XXXXXXXXXXXXXXXXXXX' + GlobalVariable.PositionAdvanceSearch)

'Clicking on Apply Search button\r\n'
WebUI.click(findTestObject('Advanced Search objects/AppySearch_button'))

WebUI.delay(100)

CustomKeywords.'globalkeywords.record.RecordNotFound'()

