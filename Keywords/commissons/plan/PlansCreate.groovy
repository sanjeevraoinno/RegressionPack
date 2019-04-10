package commissons.plan

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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

import internal.GlobalVariable

public class PlansCreate {



	KeywordLogger log

	public String Plan_Name


	@Keyword
	def createPlan(){

		try {



			log = new KeywordLogger()


			// Verifying if the landing page is "Plans" page and creating a Plan accordingly
			String Pageheading_Expected = WebUI.getText(findTestObject('Object Repository/Plans Objects/PlansHeading'))

			String Pageheading_Actual = 'Plans'

			if (Pageheading_Expected.equalsIgnoreCase(Pageheading_Actual)) {


				WebUI.click(findTestObject('Object Repository/Plans Objects/CreateNew_link'))

				WebUI.click(findTestObject('Object Repository/Plans Objects/Okbutton_calendar'))

				Calendar calendar = Calendar.getInstance()

				String timestamp = calendar.get(Calendar.HOUR_OF_DAY) + "" + calendar.get(Calendar.MINUTE)

				Plan_Name = 'TF_Plan_' + timestamp

				WebUI.setText(findTestObject('Object Repository/Plans Objects/Input_Name'), Plan_Name)

				WebUI.setText(findTestObject('Object Repository/Plans Objects/Input_Description'), 'New plan created')

				WebUI.click(findTestObject('Object Repository/Plans Objects/Save_button'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				log.logPassed('On the Plans page and created a Plan')

			}

			else {
				log.logFailed('Not able to find the Plans Heading and unable to Create Plan ...test case failed')
			}

		}

		catch(Exception e){

			log.logInfo(e.getMessage())

		}


	}



}
