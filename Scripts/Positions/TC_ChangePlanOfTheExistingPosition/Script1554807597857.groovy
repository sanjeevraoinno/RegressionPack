// Created by: Shiva
// Description: Change the plan of Existing Position
// Created date: 4/8/2019
// Modified date: 4/9/2019 --> Stabilized the code by creating the DOM object for save icon.
 
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords

WebUI.callTestCase(findTestCase('Positions/TC_GeneralSearchPosition'), [('PositionName') : 'TF_Position_190405_182023\r\n'], 
    FailureHandling.STOP_ON_FAILURE)

Robot r = new Robot()

WebUI.waitForPageLoad(20)

if (WebUI.verifyElementVisible(findTestObject('PositionObjects/Assign Plan On Position/EditIcon'))) {
    WebUI.click(findTestObject('PositionObjects/Change Plan Of The Existing Position/EditIcon'))

    WebUI.delay(3)

    WebUI.waitForElementVisible(findTestObject('PositionObjects/Change Plan Of The Existing Position/PlanField'), 10)

    WebUI.click(findTestObject('PositionObjects/Change Plan Of The Existing Position/PlanField'))

    WebUI.waitForElementClickable(findTestObject('PositionObjects/Change Plan Of The Existing Position/PlanFieldSearch'), 
        10)

    WebUI.click(findTestObject('PositionObjects/Change Plan Of The Existing Position/PlanFieldSearch'))

    WebUI.setText(findTestObject('PositionObjects/Change Plan Of The Existing Position/PlanFieldSearch'), PlanName)

    WebUI.delay(3)

    r.keyPress(KeyEvent.VK_ENTER)

    r.keyRelease(KeyEvent.VK_ENTER)

    if (WebUI.scrollToPosition(50, 50)) {
        WebUI.scrollToElement(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'), 10)

        WebUI.waitForElementClickable(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'), 10)

        WebUI.click(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon') //creating DOM for the Object
            )
    } else {
        try {
            WebElement element = WebUiBuiltInKeywords.findWebElement(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'))

            KeywordUtil.logInfo('Clicking element')

            element.click()

            KeywordUtil.markPassed('Element has been clicked')
        }
        catch (WebElementNotFoundException e) {
            KeywordUtil.markFailed('Element not found')
        } 
        catch (Exception e) {
            KeywordUtil.markFailed('Fail to click on element')
        } 
    }
} else {
    KeywordUtil.logInfo('Unable click on the Edit Icon.')

    KeywordUtil.logInfo('Cannot assign Participant and Title to the Position.')
}

