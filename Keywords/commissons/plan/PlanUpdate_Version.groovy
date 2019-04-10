// Created by: Sasank
// Description: This test case updates version of an existing Plan
// Created date:08.04.2019
// Modified date:09.04.2019
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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

import internal.GlobalVariable

public class PlanUpdate_Version {


	KeywordLogger log

	@Keyword
	def updatePlanVersion(){

		try{

			log = new KeywordLogger()


			WebUI.click(findTestObject('Plans Objects/rowclick'))

			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

			WebUI.waitForElementClickable(findTestObject('Plans Objects/EditVersion'), 100)

			//need to add a condition here...
			String ActualEditButton = WebUI.getText(findTestObject('Plans Objects/EditVersion'))
			String ExpectedEditButton = 'Edit Version'

			if (ActualEditButton.equalsIgnoreCase(ExpectedEditButton)){

				WebUI.click(findTestObject('Plans Objects/EditVersion'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				WebUI.waitForElementClickable(findTestObject('Plans Objects/Dateselecticon1'),100)

				WebUI.click(findTestObject('Plans Objects/Dateselecticon1'))

				WebUI.click(findTestObject('Plans Objects/Datedropdown'))

				WebUI.click(findTestObject('Plans Objects/Periodsearchicon'))

				WebUI.setText(findTestObject('Plans Objects/Periodsearchicon'),'February 2019')

				Robot robot = new Robot()

				robot.keyPress(KeyEvent.VK_ENTER)

				Thread.sleep(2000)

				robot.keyRelease(KeyEvent.VK_ENTER)

				WebUI.click(findTestObject('Plans Objects/OKbutton'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				WebUI.click(findTestObject('Plans Objects/savebutton'))

				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)

				log.logPassed('Updated successfully')
			}

			else {
				log.logFailed('Didnot find Edit Version button')
			}

			//Click on Cancel button

			WebUI.waitForElementClickable(findTestObject('Plans Objects/cancelbutton'),100)

			WebUI.click(findTestObject('Plans Objects/cancelbutton'))


		}

		catch(Exception e){

			log.logInfo(e.getMessage())

		}

	}


}
