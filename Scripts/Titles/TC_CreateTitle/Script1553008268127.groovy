 // Created by: Shiva
// Description: Creating a Title
// Created date: 3/18/2019
// Modified date: 3/26/2019
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Titles/TC_NavigationToTitles'), [('TitleName') : 'Title_9', ('ORG') : 'Organization', ('Titletxt') : 'Titles'], 
    FailureHandling.STOP_ON_FAILURE)

Robot rob = new Robot()

boolean titleAddIcon = WebUI.verifyElementVisible(findTestObject('Titles Objects/Create Title/Add_Icon'))

// To write the messages into the report
KeywordLogger log = new KeywordLogger()

if (titleAddIcon == true) {
    'Click on Add icon available on Title Summary bar'
    WebUI.click(findTestObject('Titles Objects/Create Title/Add_Icon'))
	
    
    WebUI.click(findTestObject('Titles Objects/Create Title/Effective_Start_Date'))

    WebUI.waitForElementVisible(findTestObject('Titles Objects/Create Title/StartDate_Period_Search'), 5)
	
	WebUI.waitForElementClickable(findTestObject('Titles Objects/Create Title/StartDate_Period_Search'), 10)
    WebUI.click(findTestObject('Titles Objects/Create Title/StartDate_Period_Search'))
    'Select the effective start and end date'
    WebUI.setText(findTestObject('Titles Objects/Create Title/StartDate_Period_Search'), startDate)
	Thread.sleep(2000)
	
	
  

    rob.keyPress(KeyEvent.VK_ENTER)

   

    rob.keyRelease(KeyEvent.VK_ENTER)

    WebUI.waitForElementClickable(findTestObject('Titles Objects/Create Title/Period_OK_Button'), 5)

    WebUI.click(findTestObject('Titles Objects/Create Title/Period_OK_Button'))

    //	Calendar calendar = Calendar.getInstance()
    //	
    //	String timestamp = (calendar.get(Calendar.HOUR_OF_DAY) + '') + calendar.get(Calendar.MINUTE)
    //	
    //    String DynamicTitleName =       titleName+"_" +timestamp
    //	
    //	Tname=DynamicTitleName.replace('','_') 
    //	
    //	println(Tname)
    mydate = new Date()

  String dynamicTitleName = CustomKeywords.'commonUtilities.TimeStamp.timeStamp'(titleName)

    //required format of the current date
    //    currentdate_ = mydate.format('MMddYY')
    //
    //    currentTime_ = mydate.format('HHmmss')
    //
    //    timestamp = ((currentdate_ + '_') + currentTime_)
    //
    //    dynamicTitleName = (titleName + timestamp)
  
  
    ' Fill the detail and Click on Save icon'
	WebUI.waitForElementClickable(findTestObject('Titles Objects/Create Title/Name_Field'), 5)
	
	WebUI.click(findTestObject('Titles Objects/Create Title/Name_Field'))
    WebUI.setText(findTestObject('Titles Objects/Create Title/Name_Field'), dynamicTitleName)

    WebUI.waitForElementClickable(findTestObject('Titles Objects/Create Title/Name_Field'), 5)

    // WebUI.click(findTestObject('Titles Objects/Create Title/BU_field'))
    //WebUI.setText(findTestObject('Titles Objects/Create Title/BU_field'), bu_text)
    WebUI.click(findTestObject('Titles Objects/Create Title/Save_Icon'))

    WebUI.takeScreenshot()

    KeywordUtil.markPassed('User is able to create a Title')

    log.logPassed('Tilte Creation is Successful.')
} else {
    KeywordUtil.markFailed('Failed! --User is unable to create a Tile')

    log.logPassed('Tilte Creation is not Successful.')
}

