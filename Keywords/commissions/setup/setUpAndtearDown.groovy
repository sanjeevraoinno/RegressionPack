package commissions.setup

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.testng.annotations.*
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger


import internal.GlobalVariable

public class setUpAndtearDown {

	@BeforeTest
	@Keyword
	def setUp(){

		WebUI.openBrowser('')

		WebUI.navigateToUrl(findTestData("Login/LoginData").getValue(1,1))

		WebUI.maximizeWindow()

		'Providing the Username'
		WebUI.setText(findTestObject('Login_Navigation_Logout Objects/input_Username_username'), findTestData("Login/LoginData").getValue(2,1))

		'Providing the Password'
		WebUI.setText(findTestObject('Login_Navigation_Logout Objects/input_Password_password'), findTestData("Login/LoginData").getValue(3,1))

		'Clicking  the submit button '
		WebUI.click(findTestObject('Login_Navigation_Logout Objects/Login_Button'))
	}


}
