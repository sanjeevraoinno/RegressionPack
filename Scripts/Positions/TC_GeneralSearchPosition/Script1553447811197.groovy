// Created by: Shiva
// Description: Creating a Title
// Created date: 3/26/2019
// Modified date: 


import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Positions/TC_NavigationToPositions'), [('PositionName') : 'Title_9', ('ORG') : 'Organization'
        , ('Positiontxt') : 'Positions'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

boolean gsearch = WebUI.verifyElementVisible(findTestObject('PositionObjects/General Search/General_search_icon'))

if (gsearch) {
    WebUI.waitForElementClickable(findTestObject('PositionObjects/General Search/General_search_icon'), 15)

    'Click on the General Seacrh icon'
    WebUI.click(findTestObject('PositionObjects/General Search/General_search_icon'))

    'Click on the General Search Texbox'
    WebUI.click(findTestObject('PositionObjects/General Search/Gerneral_search_textbox'))

    'Searching the  Name of the Position'
    WebUI.setText(findTestObject('PositionObjects/General Search/Gerneral_search_textbox'), PositionName)

    WebUI.click(findTestObject('PositionObjects/General Search/General_search_icon'))

    'Validing when recond not found'
    CustomKeywords.'globalkeywords.record.RecordNotFound'()

    log.logPassed('Position search is successful')
} else {
    KeywordUtil.markFailed('Unable to find the General Searchbox')

    log.logFailed('Position search is not successful')
}

