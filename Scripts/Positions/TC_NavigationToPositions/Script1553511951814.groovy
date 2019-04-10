 // Created by: Shiva
// Description: Navigation to Positions workspace
// Created date: 3/18/2019
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.testng.Assert as Assert

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/TC_CommissionLoginPage'), [('vHeader_Name') : 'Sales Performance Home '
        , ('vManager_Org') : 'Manage Organization'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(100)

boolean org_tab_visisble = WebUI.verifyElementVisible(findTestObject('PositionObjects/Icon_Organization'))

if (org_tab_visisble == true) {
    WebUI.mouseOver(findTestObject('PositionObjects/Icon_Organization'))

    'Clicking on Organization icon\r\n'
    WebUI.click(findTestObject('PositionObjects/Organization'))

    //
    'Verifying the linktext of Organization\r\n'
    Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/PositionObjects/Organization')), ORG)

    println('User is able to navigate to Organization tab')

	WebUI.waitForElementVisible(findTestObject('Object Repository/PositionObjects/PositionsLink'), 100)

	boolean position_visible = WebUI.verifyElementVisible(findTestObject('PositionObjects/PositionsLink'))

	if (position_visible == true) {
		'User able to find the Position worksapce link'
		WebUI.mouseOver(findTestObject('Object Repository/PositionObjects/PositionsLink'), FailureHandling.STOP_ON_FAILURE)

		'Clicking on Positions link\r\n\r\n'
		WebUI.click(findTestObject('Object Repository/PositionObjects/PositionsLink'))

		'Verifying the linktext of Positions\r\n'
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/PositionObjects/PositionsHeading')), Positiontxt)

		KeywordUtil.markPassed('User is able to navigate Postios Workspace')
		} else {
				KeywordUtil.markFailed('Position is not visible')
				}
}

		 else {
			 	'Organisation tab is not visible'
				 	KeywordUtil.markFailed('Organisation tab is not visible')
}

