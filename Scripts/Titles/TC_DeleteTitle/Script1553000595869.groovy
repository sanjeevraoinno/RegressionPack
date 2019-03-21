 // Created by: Shiva
// Description: Deleting a Title
// Created date: 3/19/2019
// Modified date:
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Login_Navigation_Logout/TC_CommissionLoginPage'), [('vHeader_Name') : 'Sales Performance Home '
        , ('vManager_Org') : 'Manage Organization'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Titles/TC_NavigationToTitles'), [('TitleName') : 'Title_9', ('ORG') : 'Organization', ('Titletxt') : 'Titles'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Titles/TC_GeneralSearchTitle'), [('titleName') : 'Title_9'], FailureHandling.STOP_ON_FAILURE)

// To write the messages into the report
KeywordLogger log = new KeywordLogger()

if (WebUI.verifyElementClickable(findTestObject('Titles Objects/Delete_Title/deleteIcon'))) {
    WebUI.click(findTestObject('Titles Objects/Delete_Title/deleteIcon'))

    boolean yesConfiramtaion = WebUI.verifyElementVisible(findTestObject('Titles Objects/Delete_Title/deleteConfirmationYes'))

    if (yesConfiramtaion) {
        WebUI.click(findTestObject('Titles Objects/Delete_Title/deleteConfirmationYes'))
		log.logInfo("Delete confirmation window is Visible")
    } else {
        KeywordUtil.markFailed('Delete confirmation window is not visible')

        log.logFailed('Unable to Delete the Title')
    }
	
	log.logPassed("Title delete is Successful")
} else {
    KeywordUtil.markFailed('Selected Title is not deleted')

    log.logFailed('Unable to Delete the Title')
}

