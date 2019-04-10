// Created by: Sasank
// Description: This test case creates a Measurement Rule and add it to an existing Plan
// Created date:09.04.2019
// Modified date:10.04.2019
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
import com.kms.katalon.core.logging.KeywordLogger

import internal.GlobalVariable

public class MeasurementRuletoPlan {

	KeywordLogger log
	@Keyword
	def addMeasurementRuleToPlan(){

		try{

			log = new KeywordLogger()

			String ActualtextMeasurement = WebUI.getText(findTestObject('Plans Objects/textMeasurement'))
			String ExpectedtextMeasurement = 'Measurements'

			if (ActualtextMeasurement.equalsIgnoreCase(ExpectedtextMeasurement)){

				WebUI.click(findTestObject('Plans Objects/CreateNewRuleButton_Measurement'))

				WebUI.click(findTestObject('Plans Objects/OkButtonRule'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				WebUI.setText(findTestObject('Plans Objects/CreditRuleName'),'MR_TF_3')

				WebUI.click(findTestObject('Plans Objects/savebutton'))

				log.logPassed('Successfully added Measurement Rule to Plan')
			}

			else {
				log.logFailed('Didnot find Create New button for Measurement')
			}

		}

		catch(Exception e){

			log.logInfo(e.getMessage())

		}

	}
}
