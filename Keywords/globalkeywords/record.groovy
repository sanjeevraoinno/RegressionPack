package globalkeywords
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class record {

	@Keyword

	def RecordNotFound() throws Exception{
		try {
			boolean norecord = WebUI.waitForElementPresent(findTestObject('Object Repository/Globalkeyword/NoRecordsFound') , 10)

			if (norecord) {
				'The Record you are searching Not Found.  Test-Case Failed'
				KeywordUtil.markFailed('Record Not found')
				//KeywordUtil.logInfo('No Records Found.')
				KeywordLogger logger = new KeywordLogger()

				logger.logInfo('No Records Found.')
				//return Exception == null
			}
		}
		catch (Exception e) {
		}
	}
}