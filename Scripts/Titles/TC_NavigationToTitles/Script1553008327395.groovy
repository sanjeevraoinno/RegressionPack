// Created by: Shiva
// Description: Navigation to Titles workspace
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

boolean org_tab_visisble = WebUI.verifyElementVisible(findTestObject('Titles Objects/Icon_Organization'))

if (org_tab_visisble == true) {
    WebUI.mouseOver(findTestObject('Titles Objects/Icon_Organization'))

    'Clicking on Organization icon\r\n'
    WebUI.click(findTestObject('Titles Objects/Icon_Organization'))

    'Verifying the linktext of Organization\r\n'
    Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Titles Objects/Organization')), ORG)

    println('User is able to navigate to Administration tab')
} else {
    'Organisation tab is not visible'
    KeywordUtil.markFailed('Organisation tab is not visible')
}

boolean title_visisbe = WebUI.verifyElementVisible(findTestObject('Titles Objects/Link_Titles'))

if (title_visisbe == true) {
    'User able to find the Title worksapce link'
    WebUI.waitForElementVisible(findTestObject('Titles Objects/Link_Titles'), 4)

    WebUI.mouseOver(findTestObject('Titles Objects/Link_Titles'), FailureHandling.STOP_ON_FAILURE)

    'Clicking on Titles link\r\n\r\n'
    WebUI.click(findTestObject('Titles Objects/Link_Titles'))

    'Verifying the linktext of Titles\r\n'
    Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/Titles Objects/Titles')), Titletxt)

    KeywordUtil.markPassed('User is able to navigate Title Workspace' //WebUI.callTestCase(findTestCase('Titles/TC_SetCalendarTitle'), [('Txt_calendar') : 'January 2018\r\n'], FailureHandling.STOP_ON_FAILURE)
        )
} else {
    KeywordUtil.markFailed('title  is not visible')
}

