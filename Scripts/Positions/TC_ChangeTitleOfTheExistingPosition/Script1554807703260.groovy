import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Positions/TC_GeneralSearchPosition'), [('PositionName') : 'TF_Position_190405_182023\r\n'], 
    FailureHandling.STOP_ON_FAILURE)
Robot r = new Robot()


WebUI.waitForPageLoad(20)

if(WebUI.verifyElementVisible(findTestObject('PositionObjects/ReferParticipantAndTilte/EditIcon')))

{
WebUI.click(findTestObject('PositionObjects/ReferParticipantAndTilte/EditIcon'))

WebUI.delay(3)

    if(WebUI.verifyElementPresent(findTestObject('PositionObjects/ReferParticipantAndTilte/TitleField'), 20))
    {


	WebUI.waitForElementVisible(findTestObject('PositionObjects/ReferParticipantAndTilte/TitleField'), 20)

	WebUI.click(findTestObject('PositionObjects/ReferParticipantAndTilte/TitleField'))

	WebUI.waitForElementVisible(findTestObject('PositionObjects/ReferParticipantAndTilte/TitleFieldSearch'), 20)

	WebUI.click(findTestObject('PositionObjects/ReferParticipantAndTilte/TitleFieldSearch'))

	WebUI.setText(findTestObject('PositionObjects/ReferParticipantAndTilte/TitleFieldSearch'), TitleName)

     Thread.sleep(3000)

     

    r.keyPress(KeyEvent.VK_ENTER)

    r.keyRelease(KeyEvent.VK_ENTER)
	
	KeywordUtil.logInfo("Required Title is assigned to the Position.")
	
    }else{
	
	KeywordUtil.markFailed("Unable to assign the Title to the Position")
    
}



if(WebUI.scrollToPosition(50, 50)){

WebUI.scrollToElement(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'), 10)

WebUI.waitForElementClickable(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'), 10)
WebUI.click(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'))
}else{
        //creating DOM for the Object

try {
	
			WebElement element = WebUiBuiltInKeywords.findWebElement(findTestObject('PositionObjects/ReferParticipantAndTilte/SaveIcon'));
	
	
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
	} catch (WebElementNotFoundException e) {
	
				KeywordUtil.markFailed("Element not found")
	} catch (Exception e) {
				KeywordUtil.markFailed("Fail to click on element")
	}
}

}
else{
	
	KeywordUtil.logInfo("Unable click on the Edit Icon.")
	KeywordUtil.logInfo("Cannot assign Participant and Title to the Position.")
	
	
}
