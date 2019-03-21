// Created by: Shiva
// Description: Updating the Title
// Created date: 3/20/2019
// Modified date:3/21/2019



import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Titles/TC_GeneralSearchTitle'), [('titleName') : 'Title_9'], FailureHandling.STOP_ON_FAILURE)

KeywordLogger log = new KeywordLogger()

if (WebUI.verifyElementVisible(findTestObject('Titles Objects/Update Title/EditIcon')) && WebUI.verifyElementClickable(findTestObject(
        'Titles Objects/Update Title/EditIcon'))) {
    WebUI.click(findTestObject('Titles Objects/Update Title/EditIcon'))

    WebUI.waitForElementClickable(findTestObject('Titles Objects/Update Title/input_Description_description'), 5)

    WebUI.doubleClick(findTestObject('Titles Objects/Update Title/input_Description_description'))

    WebUI.setText(findTestObject('Titles Objects/Update Title/input_Description_description'), updateDescription)

    WebUI.click(findTestObject('Titles Objects/Update Title/Save_Icon'))

    
	String ExpectedUpdate = updateDescription
	String Actualupdate = WebUI.getText(findTestObject('Object Repository/Titles Objects/Update Title/input_Description_description'))

    				if(ExpectedUpdate.contentEquals(Actualupdate)){

						// KeywordUtil.markPassed('Update Title is Successful')

						log.logPassed('Update Title is Successful')
	
						log.logInfo('Update Title is Successful')
	
								}else{
								    
								    
									log.logFailed("'Update Title is not Successful'")
									}
}
		

else{
	
log.logFailed("'Update Title is not Successful'")
  }

