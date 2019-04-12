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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

	
	WebUI.callTestCase(findTestCase('EarningCodes/TC_NavigateEarningCodes'), [:], FailureHandling.STOP_ON_FAILURE)
	
	KeywordLogger log = new KeywordLogger()
	
	String HeadingEarningCodes_Expected = WebUI.getText(findTestObject('EarningCodesObjects/Headings_EarningCode'))
	
	String HeadingEarningCodes_Actual = 'Earning Codes'
	
	//not_run: WebUI.mouseOver(findTestObject('EarningCodesObjects/General Search Icon'))
	//WebUI.clickImage(findTestObject('EarningCodesObjects/General Search Icon'))
	if (HeadingEarningCodes_Expected.equalsIgnoreCase(HeadingEarningCodes_Actual)) {
		WebUI.click(findTestObject('EarningCodesObjects/General Search Icon'))
	
		WebUI.click(findTestObject('EarningCodesObjects/General Search Textbox'))
	
		WebUI.setText(findTestObject('EarningCodesObjects/General Search Textbox'), 'TF_EarningCodes1222')
	
		WebUI.click(findTestObject('EarningCodesObjects/General Search Icon'))
	
		//KeywordUtil.markPassed('EarningCodes ID is visible')
	//} else {
	 //   KeywordUtil.markFailed('EarningCodes ID is not visible')
	//}
		log.logPassed("Headings matched....EarningCodes ID is visible")
	
	}
	
	else{
		
		log.logFailed("Headings is not matching...test case failed")
	
	}
	


	CustomKeywords.'globalkeywords.record.RecordNotFound'()
	


