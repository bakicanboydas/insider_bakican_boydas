package utils.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        try {
            reporter.loadXMLConfig(new File("extent_config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        reporter.config().setReportName("Techcrunch Test Suite Report");
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
