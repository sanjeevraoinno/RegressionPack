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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.callTestCase(findTestCase('Participants/Navigation to Participant'), [('PID') : 'Payee01', ('ORG') : 'Organization'
        , ('Part_txt') : 'Participants'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Login_Navigation_Logout Objects/Icon_Calendar'), 3)

WebUI.mouseOver(findTestObject('Login_Navigation_Logout Objects/Icon_Calendar'))

WebUI.click(findTestObject('Login_Navigation_Logout Objects/Icon_Calendar'))

WebUI.click(findTestObject('Login_Navigation_Logout Objects/Calendar_Period'))

WebUI.setText(findTestObject('Login_Navigation_Logout Objects/Set Calendar Text'), Txt_calendar)

Robot robot = new Robot()

robot.keyPress(KeyEvent.VK_ENTER)

Thread.sleep(2000)

robot.keyRelease(KeyEvent.VK_ENTER)

WebUI.click(findTestObject('Login_Navigation_Logout Objects/span_Ok'))

