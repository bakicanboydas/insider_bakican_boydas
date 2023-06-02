package utils.listeners;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.logs.Log;

import java.util.Objects;

import static utils.extentReport.ExtentManager.getExtentReports;
import static utils.extentReport.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {iTestContext.setAttribute("WebDriver",this.driver);}

    @Override
    public void onFinish(ITestContext iTestContext) {getExtentReports().flush();}

    @Override
    public void onTestStart(ITestResult iTestResult){
        Log.info(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        getTest().log(Status.PASS,"Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        Log.info(getTestMethodName(iTestResult) + " test is failed.");

        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);

        getTest().log(Status.FAIL,iTestResult.getThrowable(),
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        getTest().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
