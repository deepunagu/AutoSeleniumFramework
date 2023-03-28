package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
@Test(retryAnalyzer=vTiger.GeneralUtilities.RetrtAnalyserImplemenation.class)

public void practice()
{
	Assert.fail();
	System.out.println("Hi");
}
}
