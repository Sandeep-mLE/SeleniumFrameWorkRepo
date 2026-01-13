package com.ninza.crm.listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ninza.crm.BaseclassUtility.BaseClass;

public class ListenersImplementation extends BaseClass implements ITestListener, ISuiteListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Date d = new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/" + date + "_crmreport.html");
		spark.config().setDocumentTitle("Ninza");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		//System.out.println("" + result.getMethod().getMethodName() + "Execution started");
		test = report.createTest(testCase);
		test.log(Status.INFO, testCase + " Execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test.log(Status.PASS, testCase + " Execution started");
		// System.out.println("" + result.getMethod().getMethodName() + "Execution
		// success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test.log(Status.FAIL, testCase + " Execution failed");
		//System.out.println("Execution fail");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src);
		
		
		
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		Date d = new Date();
//		String date = d.toString().replace(" ", "_").replace(":", "_");
//		File dest = new File("./screenshot/" + date + testCase + "_errorshot.png");
//		try {
//			FileHandler.copy(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test.log(Status.SKIP, testCase + " Execution skipped");
		// System.out.println("Execution skipped");
	}

}
