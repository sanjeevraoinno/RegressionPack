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

WebUI.callTestCase(findTestCase('Titles/TC_GeneralSearchTitle'), [('titleName') : 'Title_9'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

if (WebUI.verifyElementVisible(findTestObject('Titles Objects/Update Title/EditIcon')) && WebUI.verifyElementClickable(findTestObject(
        'Titles Objects/Update Title/EditIcon'))) {
    WebUI.waitForPageLoad(10)

    WebUI.click(findTestObject('Titles Objects/Assign Plan On Title/EditIcon'))

    WebUI.waitForElementVisible(findTestObject('Titles Objects/Assign Plan On Title/PlanField'), 10)

    WebUI.scrollToElement(findTestObject('Titles Objects/Assign Plan On Title/PlanField'), 10)

    WebUI.waitForElementClickable(findTestObject('Titles Objects/Assign Plan On Title/PlanField'), 10)

    WebUI.click(findTestObject('Titles Objects/Assign Plan On Title/PlanField'))

    Robot rob = new Robot()

    rob.keyPress(KeyEvent.VK_ENTER)

    Thread.sleep(2000)

    rob.keyRelease(KeyEvent.VK_ENTER)

    WebUI.delay(3)

    WebUI.waitForElementVisible(findTestObject('Titles Objects/Assign Plan On Title/planSearchIcon'), 10)

    WebUI.scrollToElement(findTestObject('Titles Objects/Assign Plan On Title/planSearchIcon'), 10)

    WebUI.delay(3)

    WebUI.click(findTestObject('Titles Objects/Assign Plan On Title/planSearchIcon'))

    WebUI.setText(findTestObject('Titles Objects/Assign Plan On Title/planSearchIcon'), PlanName)

    WebUI.waitForElementVisible(findTestObject('Titles Objects/Assign Plan On Title/SearchList'), 10)

    WebUI.click(findTestObject('Titles Objects/Assign Plan On Title/SearchList'))
} else {
    log.logFailed('\'Update Title is not Successful\'')
}

