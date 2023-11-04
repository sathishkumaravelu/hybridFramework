package referenceCode;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {
    public static void main(String[] args) {

        //Create the Physical html file
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
        //Create object for exptent reports
        ExtentReports extent = new ExtentReports();
        //Integrate the physical file and data
        extent.attachReporter(reporter);

        ExtentTest test = extent.createTest("Login test case", "Test to check the login screen");
        test.assignAuthor("Sathish");
        test.assignAuthor("Smoke");

        test.pass("Enter user name");
        test.pass("Enter password");
        test.fail("login button");
        test.skip("dashboard");

        extent.flush();
    }
}
