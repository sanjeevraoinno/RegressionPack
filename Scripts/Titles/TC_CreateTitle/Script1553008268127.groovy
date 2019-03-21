// Created by: Shiva
// Description: Creating a Title
// Created date: 3/18/2019
// Modified date:

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Titles/TC_NavigationToTitles'), [('TitleName') : 'Title_9', ('ORG') : 'Organization', ('Titletxt') : 'Titles'], 
    FailureHandling.STOP_ON_FAILURE)

boolean titleAddIcon = WebUI.verifyElementVisible(findTestObject('Titles Objects/Create Title/Add_Icon'))

// To write the messages into the report
KeywordLogger log = new KeywordLogger()


if (titleAddIcon == true) {
    'Click on Add icon available on Title Summary bar'
    WebUI.click(findTestObject('Titles Objects/Create Title/Add_Icon'))

    WebUI.click(findTestObject('Titles Objects/Create Title/Effective_Start_Date'))

    'Select the effective start and end date'
    WebUI.setText(findTestObject('Titles Objects/Create Title/StartDate_Period_Search'), startDate)

    Robot rob = new Robot()
    rob.keyPress(KeyEvent.VK_ENTER)
    Thread.sleep(2000)

    rob.keyRelease(KeyEvent.VK_ENTER)

    WebUI.waitForElementClickable(findTestObject('Titles Objects/Create Title/Period_OK_Button'), 5)

    WebUI.click(findTestObject('Titles Objects/Create Title/Period_OK_Button'))

    ' Fill the detail and Click on Save icon'
    WebUI.setText(findTestObject('Titles Objects/Create Title/Name_Field'), titleName)

  // WebUI.click(findTestObject('Titles Objects/Create Title/BU_field'))

    //WebUI.setText(findTestObject('Titles Objects/Create Title/BU_field'), bu_text)
    WebUI.click(findTestObject('Titles Objects/Create Title/Save_Icon'))

    KeywordUtil.markPassed('User is able to create a Title')
	log.logPassed("Tilte Creation is Successful.")
    }

   else {
    KeywordUtil.markFailed('Failed! --User is unable to create a Tile')
	log.logPassed("Tilte Creation is not Successful.")
	
        }

