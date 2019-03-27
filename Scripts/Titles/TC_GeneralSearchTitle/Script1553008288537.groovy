// Created by: Shiva
// Description: General Search of Tilte
// Created date: 3/19/2019
// Modified date:

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Titles/TC_NavigationToTitles'), [('TitleName') : 'Title_9', ('ORG') : 'Organization', ('Titletxt') : 'Titles'], 
    FailureHandling.STOP_ON_FAILURE)

boolean gSearchicon = WebUI.verifyElementVisible(findTestObject('Titles Objects/General Search/General_search_icon'))
// To write the messages into the report
KeywordLogger log = new KeywordLogger()

if (gSearchicon) {
    WebUI.waitForElementClickable(findTestObject('Titles Objects/General Search/General_search_icon'), 15)

	 'Click on the General Seacrh icon'
    WebUI.click(findTestObject('Titles Objects/General Search/General_search_icon'))
	
	'Click on the General Search Texbox'
    WebUI.click(findTestObject('Titles Objects/General Search/Gerneral_search_textbox'))

	'Searching the  Name of the Title'
    WebUI.setText(findTestObject('Titles Objects/General Search/Gerneral_search_textbox'), titleName)

    WebUI.click(findTestObject('Titles Objects/General Search/General_search_icon'))
    'Validing when recond not found'
    CustomKeywords.'globalkeywords.record.RecordNotFound'()
	 
	log.logPassed("Title search is successful")
	
} else {
    KeywordUtil.markFailed('Unable to find the General Searchbox')
	log.logFailed("Title search is not successful")
}

