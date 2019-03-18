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

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/Set Calendar'), [('Txt_calendar') : 'January 2010'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Participant Objects/Add_Participant'))

WebUI.click(findTestObject('Participant Objects/Calendar_Period_participant'))

WebUI.setText(findTestObject('Participant Objects/Set_Start Calendar'), Participant_calendar)

Robot robot = new Robot()

robot.keyPress(KeyEvent.VK_ENTER)

Thread.sleep(2000)

robot.keyRelease(KeyEvent.VK_ENTER)

WebUI.click(findTestObject('Participant Objects/span_Ok'))

WebUI.setText(findTestObject('Participant Objects/input_(Required)_payeeId'), Payeeid)

WebUI.click(findTestObject('Participant Objects/input_Prefix_prefix'))

WebUI.setText(findTestObject('Participant Objects/input_Prefix_prefix'), Prefix)

WebUI.click(findTestObject('Participant Objects/input_First Name_firstName'))

WebUI.setText(findTestObject('Participant Objects/input_First Name_firstName'), Firstname)

WebUI.click(findTestObject('Participant Objects/input_(Required)_lastName'))

WebUI.setText(findTestObject('Participant Objects/input_(Required)_lastName'), Lastname)

WebUI.click(findTestObject('Participant Objects/Business unit Participant'))

WebUI.setText(findTestObject('Participant Objects/Business unit Participant'), BU_txt)

Robot robot1 = new Robot()

robot1.keyPress(KeyEvent.VK_ENTER)

Thread.sleep(2000)

robot1.keyRelease(KeyEvent.VK_ENTER)

WebUI.click(findTestObject('Participant Objects/Icon_Save'))

