// Created by: 
// Description: 
// Created date:
// Modified date:
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
import org.testng.Assert;
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.openBrowser('')

WebUI.navigateToUrl('https://biz3-tst.callidusondemand.com/SalesPortal/#!/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Sales Performance Home/input_Username_username'), 'kikosana@calliduscloud.com')

WebUI.setText(findTestObject('Object Repository/Page_Sales Performance Home/input_Password_password'), 'Kiran09@@')

WebUI.click(findTestObject('Object Repository/Page_Sales Performance Home/button_Login'))

String Expectedtitle = WebUI.getWindowTitle()

String ActualTitle = "Sales Performance Home"

KeywordLogger log = new KeywordLogger()

//Verifying the title of the page
if(Expectedtitle.equalsIgnoreCase(ActualTitle)){
	
	WebUI.click(findTestObject('Object Repository/Page_Sales Performance Home/span_Administration_sap-icon s'))
	
	WebUI.click(findTestObject('Object Repository/Page_Sales Performance Home/a_Commissions'))	
	
	log.logPassed("Title matched")
}

else{
	
	log.logFailed("Title is not matching...test case failed")
}


//Verifying the availability of "Manage Plans" text, if it matches clicking on the Plan link

String ManagePlans_Expected=  WebUI.getText(findTestObject('Object Repository/Page_SAP Commissions/ManagePlansText')) 

String ManagePlans_ActualText = "Manage Plans"

if (ManagePlans_Expected.equalsIgnoreCase(ManagePlans_ActualText)){
	
	WebUI.click(findTestObject('Object Repository/Page_SAP Commissions/Plan Data'))
	
	WebUI.click(findTestObject('Object Repository/Page_SAP Commissions/Plans_Link'))
	
	log.logPassed("On the Manage Plans Panel")
	
}

else {
	
	log.logFailed("Not able to find the Manage Plans Panel ...test case failed")
}

// Verifying if the landing page is "Plans" page and creating a Plan accordingly

String Pageheading_Expected =  WebUI.getText(findTestObject('Object Repository/Page_SAP Commissions/PlansHeading'))

String Pageheading_Actual = "Plans"

if(Pageheading_Expected.equalsIgnoreCase(Pageheading_Actual)){
	
	WebUI.click(findTestObject('Object Repository/Page_SAP Commissions/CreateNew_link'))
	
	WebUI.click(findTestObject('Object Repository/Page_SAP Commissions/Okbutton_calendar'))
	
	Calendar calendar =Calendar.getInstance()
	String timestamp = calendar.get(Calendar.HOUR_OF_DAY)+":"+ calendar.get(Calendar.MINUTE)
	
	WebUI.setText(findTestObject('Object Repository/Page_SAP Commissions/Input_Name'), 'TF_Plan_'+ timestamp)
	
	WebUI.setText(findTestObject('Object Repository/Page_SAP Commissions/Input_Description'), 'New plan created')
	
	WebUI.click(findTestObject('Object Repository/Page_SAP Commissions/Save_button'))
	
	log.logPassed("On the Plans page and created a Plan")
	
}

else {
	
	log.logFailed("Not able to find the Plans Heading ...test case failed")
	
}
