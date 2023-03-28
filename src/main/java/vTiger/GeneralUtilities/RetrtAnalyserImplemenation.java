package vTiger.GeneralUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyser interface of TestNG
 * @author USER
 *
 */
public class RetrtAnalyserImplemenation implements IRetryAnalyzer {

	int count=0;
	int retryCount=3;
	/**
	 * this method will retry for 3 times
	 */
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
