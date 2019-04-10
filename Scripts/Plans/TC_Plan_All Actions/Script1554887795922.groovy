// Created by: Sasank
// Description: This test case covers the following: Create Plan, Search Plan, Update Plan and Delete Plan
// Created date:19.03.2019
// Modified date:25.03.2019
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
import org.testng.Assert as Assert
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger


	KeywordLogger log
	String Planname
	String Updatedplandescription
	int j=0

try{
	
	WebUI.callTestCase(findTestCase('Plans/TC_NavigatePlan'), [('Plan_data') : 'Plan Data', ('Plan_txt') : 'Plans'], FailureHandling.STOP_ON_FAILURE)
	
	log = new KeywordLogger()
	
	
	// Verifying if the landing page is "Plans" page and creating a Plan accordingly
	String Pageheading_Expected = WebUI.getText(findTestObject('Object Repository/Plans Objects/PlansHeading'))
	
	String Pageheading_Actual = 'Plans'
	
	if (Pageheading_Expected.equalsIgnoreCase(Pageheading_Actual)) {
		
		for (int i=0; i<2; i++){
			
				j=j+1
			
				WebUI.click(findTestObject('Object Repository/Plans Objects/CreateNew_link'))
			
				WebUI.click(findTestObject('Object Repository/Plans Objects/Okbutton_calendar'))
			
				Calendar calendar = Calendar.getInstance()
			
				String timestamp = calendar.get(Calendar.HOUR_OF_DAY) + "" + calendar.get(Calendar.MINUTE)
				
				Planname = 'TF_Plan_' + timestamp
				
				WebUI.setText(findTestObject('Object Repository/Plans Objects/Input_Name'), Planname)
			
				WebUI.setText(findTestObject('Object Repository/Plans Objects/Input_Description'), 'New plan created')
			
				WebUI.click(findTestObject('Object Repository/Plans Objects/Save_button'))
				
				WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)
				
				log.logPassed('On the Plans page and created a Plan')	
				
				
				if (j==1){
					
					//searching the Plan
					
					WebUI.waitForElementClickable(findTestObject('Plans Objects/Gerneral search textbox'), 100)
					
					WebUI.click(findTestObject('Plans Objects/General_search_icon'))
					
					WebUI.click(findTestObject('Plans Objects/Gerneral search textbox'))
					
					WebUI.setText(findTestObject('Plans Objects/Gerneral search textbox'), Planname)
					
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
				 
				 //updating the plan
				 
				 Updatedplandescription = '********Plan has been updated*********'
				 
				 WebUI.click(findTestObject('Plans Objects/rowclick'))
				 
				 WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)
				 
				 WebUI.waitForElementClickable(findTestObject('Plans Objects/EditVersion'), 100)
				 
				 //need to add a condition here...
				 
				 
				 String ActualEditButton = WebUI.getText(findTestObject('Plans Objects/EditVersion'))
				 String ExpectedEditButton = 'Edit Version'
				 
				 if (ActualEditButton.equalsIgnoreCase(ExpectedEditButton)){
					 
					 WebUI.click(findTestObject('Plans Objects/EditVersion'))
					 
					 WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)
					 
					 WebUI.clearText(findTestObject('Plans Objects/cleardescription'))
					 
					 WebUI.setText(findTestObject('Plans Objects/cleardescription'), Updatedplandescription)
					 
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
					 
				 WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)
					 
				 String ActualDescription = WebUI.getText(findTestObject('Plans Objects/updateddesc'))
					 
				 if(ActualDescription.equalsIgnoreCase(Updatedplandescription)){
						 
						 log.logPassed('updated desc is:' + ActualDescription )
					 }
					 
				 else {
						 log.logFailed('Didnot find updated desc')
					 }
							
			}
					
				
				if (j==2){
					
					//searching the Plan
					
					WebUI.waitForElementClickable(findTestObject('Plans Objects/Gerneral search textbox'), 100)
					
					WebUI.click(findTestObject('Plans Objects/General_search_icon'))
					
					WebUI.click(findTestObject('Plans Objects/Gerneral search textbox'))
					
					WebUI.setText(findTestObject('Plans Objects/Gerneral search textbox'), Planname)
					
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
				 
				 
				//Delete the Plan
				 
				 WebUI.waitForElementNotPresent(findTestObject('Object Repository/Plans Objects/Spinner'),20)
				 
				 'select the checkbox'
				 WebUI.click(findTestObject('Plans Objects/checkbox'))	 
				 
				 'click on delete button'
				 WebUI.click(findTestObject('Plans Objects/deletebutton'))
					
			}
		}
				
	}
	
	else {
		log.logFailed('Not able to find the Plans Heading and unable to Create Plan ...test case failed')
	}			 
	
}

catch(Exception e){
	
	log.logInfo(e.getMessage())

}

