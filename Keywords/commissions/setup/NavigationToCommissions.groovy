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

public class NavigationToCommissions {
	
	@Test
	@Keyword
	def navigateCommissions(){

		WebUI.waitForPageLoad(2)

		String Expectedtitle = WebUI.getWindowTitle()

		String ActualTitle = 'Sales Performance Home'

		KeywordLogger log = new KeywordLogger()

		//Verifying the title of the page
		if (Expectedtitle.equalsIgnoreCase(ActualTitle)) {
			WebUI.click(findTestObject('Object Repository/Login_Navigation_Logout Objects/Icon_Apps'))

			WebUI.click(findTestObject('Object Repository/Login_Navigation_Logout Objects/Link_Commissions'))

			log.logPassed('Title matched')
		} else {
			log.logFailed('Title is not matching...test case failed')
		}


	}
}
