 // Created by: Shiva
// Description: Creating a Position
// Created date: 3/24/2019
// Modified date:4/9/2019 -- create time Stamp method and called in this test case
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('Positions/TC_NavigationToPositions'), [('PositionName') : 'Title_9', ('ORG') : 'Organization'
        , ('Positiontxt') : 'Positions'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(100)

boolean positionAddIcon = WebUI.verifyElementVisible(findTestObject('PositionObjects/Create Position/Add_Icon'))

// To write the messages into the report
KeywordLogger log = new KeywordLogger()

if (positionAddIcon == true) {
    'Click on Add icon available on Position Summary bar'
    WebUI.click(findTestObject('PositionObjects/Create Position/Add_Icon'))

    WebUI.waitForElementClickable(findTestObject('PositionObjects/Create Position/Effective_Start_Date'), 10)

    WebUI.doubleClick(findTestObject('PositionObjects/Create Position/Effective_Start_Date'))

    WebUI.waitForElementVisible(findTestObject('PositionObjects/Create Position/StartDate_Period_Search'), 5)

    'Select the effective start and end date'
    WebUI.setText(findTestObject('PositionObjects/Create Position/StartDate_Period_Search'), startDate)

    Robot rob = new Robot()

    rob.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    rob.keyRelease(KeyEvent.VK_ENTER)

    WebUI.waitForElementClickable(findTestObject('PositionObjects/Create Position/Period_OK_Button'), 5)

    WebUI.click(findTestObject('PositionObjects/Create Position/Period_OK_Button'))

    WebUI.waitForElementClickable(findTestObject('PositionObjects/Create Position/Name_Field'), 5)

    WebUI.doubleClick(findTestObject('PositionObjects/Create Position/Name_Field'))

    // mydate = new Date()
    //required format of the current date
    //    currentdate_ = mydate.format('MMddYY')
    //
    //    currentTime_ = mydate.format('HHmmss')
    //
    //    timestamp = ((currentdate_ + '_') + currentTime_)
    //
    String dynamicPositionName = CustomKeywords.'commonUtilities.TimeStamp.timeStamp'(positionName)

    ' Fill the detail and Click on Save icon'
    WebUI.setText(findTestObject('PositionObjects/Create Position/Name_Field'), dynamicPositionName)

    WebUI.waitForElementClickable(findTestObject('PositionObjects/Create Position/TitleField'), 5)

    WebUI.doubleClick(findTestObject('PositionObjects/Create Position/TitleField'))

    WebUI.waitForElementClickable(findTestObject('PositionObjects/Create Position/TitleFieldSearch'), 5)

    WebUI.click(findTestObject('PositionObjects/Create Position/TitleFieldSearch'))

    WebUI.setText(findTestObject('PositionObjects/Create Position/TitleFieldSearch'), requiredTitle)

    Robot rob1 = new Robot()

    rob1.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    rob1.keyRelease(KeyEvent.VK_ENTER)

    rob1.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    rob1.keyRelease(KeyEvent.VK_ENTER)

    // WebUI.click(findTestObject('Titles Objects/Create Title/BU_field'))
    //WebUI.setText(findTestObject('Titles Objects/Create Title/BU_field'), bu_text)
    WebUI.click(findTestObject('PositionObjects/Create Position/Save_Icon'))

    KeywordUtil.markPassed('User is able to create a Position')

    log.logPassed('Position Creation is Successful.')

    // setting gbloal varibal for search
    GlobalVariable.PositionAdvanceSearch = dynamicPositionName

    println(GlobalVariable.PositionAdvanceSearch)
	
	WebUI.delay(10)
} else {
    KeywordUtil.markFailed('Failed! --User is unable to create a Position')

    log.logPassed('Position Creation is not Successful.')
}

