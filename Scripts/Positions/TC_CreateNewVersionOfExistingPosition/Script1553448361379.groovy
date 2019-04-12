// Created by: Shiva
// Description: Create new version of Existing Position
// Created date: 3/29/2019
// Modified date:
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Positions/TC_NavigationToPositions'), [('PositionName') : 'Title_9', ('ORG') : 'Organization'
        , ('Positiontxt') : 'Positions'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(100)

KeywordLogger log = new KeywordLogger()

WebUI.scrollToPosition(0, 50)

WebUI.waitForElementVisible(findTestObject('PositionObjects/Manage Version/Icon_ManageVersion'), 10)

boolean verstionIconPressent = WebUI.waitForElementPresent(findTestObject('PositionObjects/Manage Version/Icon_ManageVersion'), 
    10)

if (verstionIconPressent == true) {
    WebUI.waitForElementClickable(findTestObject('PositionObjects/Manage Version/Icon_ManageVersion'), 10)

    WebUI.click(findTestObject('PositionObjects/Manage Version/Icon_ManageVersion'))

    WebUI.waitForPageLoad(15)

    WebUI.scrollToElement(findTestObject('PositionObjects/Manage Version/add_Period'), 5)

    WebUI.waitForElementVisible(findTestObject('PositionObjects/Manage Version/add_Period'), 5)

    WebUI.delay(3)

    boolean addPeriodIcon = WebUI.verifyElementVisible(findTestObject('PositionObjects/Manage Version/add_Period'))

    if (addPeriodIcon) {
        WebUI.click(findTestObject('PositionObjects/Manage Version/add_Period'))

        WebUI.scrollToElement(findTestObject('PositionObjects/Manage Version/Effective_Start_Date'), 5)

        WebUI.waitForElementClickable(findTestObject('PositionObjects/Manage Version/Effective_Start_Date'), 15)

        WebUI.click(findTestObject('PositionObjects/Manage Version/Effective_Start_Date'))

        'Select the effective start and end date'
        WebUI.setText(findTestObject('PositionObjects/Manage Version/autosearch_Date'), startDate)

        Robot rob = new Robot()

        rob.keyPress(KeyEvent.VK_ENTER)

        Thread.sleep(2000)

        rob.keyRelease(KeyEvent.VK_ENTER)

        WebUI.scrollToElement(findTestObject('PositionObjects/Manage Version/Ok_Button'), 10)

        WebUI.click(findTestObject('PositionObjects/Manage Version/Ok_Button'))

        rob.keyPress(KeyEvent.VK_ENTER)

        Thread.sleep(2000)

        rob.keyRelease(KeyEvent.VK_ENTER)

        log.logInfo('Added period to Position Version ')

        log.logPassed('New Version of Position Created')

        'Verfying wheter the version created'
        String ActualVersion = WebUI.getText(findTestObject('PositionObjects/Manage Version/versionList'))

        String ExpectVesrion = '2/1/2006'

        if (ActualVersion.contentEquals(ExpectVesrion)) {
            log.logInfo('Version Created Successfully')

            log.logPassed('Passed')
        } else {
            log.logFailed('Version not created')
        }
    } else {
        log.logInfo('Add period for create vesrion is failed')
    }
} else {
    log.logFailed('Unable to create the new version of Position')
}

