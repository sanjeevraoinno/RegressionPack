// Created by: Shiva
// Description: Create New Version Of Existing Title
// Created date: 3/27/2019
// Modified date: 3/29/2019
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

WebUI.callTestCase(findTestCase('Titles/TC_NavigationToTitles'), [('ORG') : 'Organization', ('Titletxt') : 'Titles'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

WebUI.scrollToPosition(0, 50)

WebUI.waitForElementVisible(findTestObject('Titles Objects/Manage Version/Icon_ManageVersion'), 10)

boolean verifyicon = WebUI.verifyElementVisible(findTestObject('Titles Objects/Manage Version/Icon_ManageVersion'))

if (verifyicon == true) {
    WebUI.waitForElementClickable(findTestObject('Titles Objects/Manage Version/Icon_ManageVersion'), 15)

    WebUI.click(findTestObject('Titles Objects/Manage Version/Icon_ManageVersion'))

    WebUI.waitForPageLoad(15)

    WebUI.scrollToElement(findTestObject('Titles Objects/Manage Version/add_Period'), 5)

    WebUI.waitForElementVisible(findTestObject('Titles Objects/Manage Version/add_Period'), 5)

    WebUI.delay(3)

    boolean addPeriodIcon = WebUI.verifyElementVisible(findTestObject('Titles Objects/Manage Version/add_Period'))

    if (addPeriodIcon) {
        WebUI.click(findTestObject('Titles Objects/Manage Version/add_Period'))

        WebUI.scrollToElement(findTestObject('Titles Objects/Manage Version/Effective_Start_Date'), 5)

        WebUI.waitForElementClickable(findTestObject('Titles Objects/Manage Version/Effective_Start_Date'), 15)

        WebUI.click(findTestObject('Titles Objects/Manage Version/Effective_Start_Date'))

        'Select the effective start and end date'
        WebUI.setText(findTestObject('Titles Objects/Manage Version/autosearch_Date'), startDate)

        Robot rob = new Robot()

        rob.keyPress(KeyEvent.VK_ENTER)

        Thread.sleep(2000)

        rob.keyRelease(KeyEvent.VK_ENTER)

        WebUI.scrollToElement(findTestObject('Titles Objects/Manage Version/Ok_Button'), 10)

        //  WebUI.waitForElementClickable(findTestObject('Titles Objects/Manage Version/Ok_Button'), 10)
        WebUI.click(findTestObject('Titles Objects/Manage Version/Ok_Button'))

        rob.keyPress(KeyEvent.VK_ENTER)

        Thread.sleep(2000)

        rob.keyRelease(KeyEvent.VK_ENTER)

        log.logInfo('Added period to Title Version ')

        log.logPassed('New Version of Title Created')

        'Verfying wheter the version created'
		
		String ActualVersion = WebUI.getText(findTestObject('Titles Objects/Manage Version/versionList'))
		String ExpectVesrion= "2/1/2006"
		
		if(ActualVersion.contentEquals(ExpectVesrion)){
         log.logInfo("Version Created Successfully")
		 log.logPassed("Passed")
		} else{
		log.logFailed("Version not created")
		
		}
		 		
		
		
		
		
		
    } else {
        log.logInfo('Add period for create vesrion is failed')
    }
} else {
    log.logFailed('Unable to create the new version of Title')
}

