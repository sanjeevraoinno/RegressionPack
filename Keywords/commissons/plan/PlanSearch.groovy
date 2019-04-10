package commissons.plan

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import org.testng.annotations.Test

public class PlanSearch extends PlansCreate{



	KeywordLogger log

	@Keyword
	def searchPlan(){

		try{

			PlanSearch search = new PlanSearch()

			search.createPlan()

			log = new KeywordLogger()

			//searching the Plan

			WebUI.waitForElementClickable(findTestObject('Plans Objects/Gerneral search textbox'), 100)

			WebUI.click(findTestObject('Plans Objects/General_search_icon'))

			WebUI.click(findTestObject('Plans Objects/Gerneral search textbox'))

			WebUI.setText(findTestObject('Plans Objects/Gerneral search textbox'), search.Plan_Name)

			WebUI.click(findTestObject('Plans Objects/General_search_icon'))

			//Verifying the unique Plan present

			String ExpectedText = WebUI.getText(findTestObject('Object Repository/Plans Objects/Showing_text'))
			String ActualText = 'Showing 1 to 1 of 1 entries'

			if (ExpectedText.equalsIgnoreCase(ActualText)){

				log.logPassed('Successfully searched the plan')
			}

			else {
				log.logFailed('Not able to search the Plan ...test case failed')
			}



		}

		catch(Exception e){

			log.logInfo (e.getMessage())

		}

	}
}
