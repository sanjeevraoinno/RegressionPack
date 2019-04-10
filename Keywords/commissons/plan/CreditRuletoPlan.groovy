// Created by: Sasank
// Description: This test case creates a Credit Rule and add it to an existing Plan
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


public class CreditRuletoPlan {

	KeywordLogger log
	@Keyword
	def addCreditRuleToPlan(){

		try{

			log = new KeywordLogger()


			WebUI.click(findTestObject('Plans Objects/rowclick'))

			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

			WebUI.waitForElementClickable(findTestObject('Plans Objects/EditVersion'), 100)

			String ActualEditButton = WebUI.getText(findTestObject('Plans Objects/EditVersion'))
			String ExpectedEditButton = 'Edit Version'

			if (ActualEditButton.equalsIgnoreCase(ExpectedEditButton)){

				WebUI.click(findTestObject('Plans Objects/EditVersion'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				log.logPassed('Found Edit Version button')

			}

			else {
				log.logFailed('Didnot find Edit Version button')
			}

			String ActualtextCredits = WebUI.getText(findTestObject('Plans Objects/textcredit'))
			String ExpectedtextCredits = 'Credits'

			if(ActualtextCredits.equalsIgnoreCase(ExpectedtextCredits)){

				WebUI.click(findTestObject('Plans Objects/CreateNewRuleButton'))

				WebUI.click(findTestObject('Plans Objects/OkButtonRule'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				WebUI.setText(findTestObject('Plans Objects/CreditRuleName'),'CR_TF_3')

				WebUI.click(findTestObject('Plans Objects/savebutton'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				log.logPassed('Successfully added Credit Rule to Plan')

			}

			else {
				log.logFailed('Didnot find Create New button for adding a Credit Rule')
			}

		}

		catch(Exception e){

			log.logInfo(e.getMessage())

		}

	}
}
