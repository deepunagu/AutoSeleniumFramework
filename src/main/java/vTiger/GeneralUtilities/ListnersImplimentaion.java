package vTiger.GeneralUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class contains implementationn for ITestListeners interface of TestNG
 * @author USER
 *
 */
public class ListnersImplimentaion implements ITestListener{
//import org.testng.ITestListener;
	ExtentReports report;//import com.aventstack.extentreports.ExtentReports;
	ExtentTest test;//import com.aventstack.extentreports.ExtentTest
	public void onTestStart(ITestResult result)//import org.testng.ITestResult; 
	{
	String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---Execution started");
		test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+" --- FAIL");//import com.aventstack.extentreports.Status;
		test.log(Status.INFO, result.getThrowable());
		String screenshotName = methodName+"-"+jUtil.getSystemDateInFormat();
		
	try {
		String path =wUtil.takeScreenShot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" --- SKIP");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {	
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
			
	}

	public void onStart(ITestContext context) {
		System.out.println("suite execution started");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);//import com.aventstack.extentreports.reporter.configuration.Theme;
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Reporter Name", "Deepika");
	}

	public void onFinish(ITestContext context) {
		System.out.println("suite execution finished");
		report.flush();
	}

}
