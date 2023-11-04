package vennilaScript;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sdet5.core.base.baseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TC_002_CreateLead extends baseClass {
    public static  ChromeDriver driver;
    @BeforeTest
    public void setValues() {
        testName ="Dashboard";
        testDescription = "click crmsfa";
        testAuthor = "Sathish";
        testCategory = "functional";
        excelFileName="Login";

    }
    @Test(dataProvider = "fetchData")
    public void tc_02_CreateLead(String username, String password) throws IOException {
        try{
            ChromeOptions chrome_options = new ChromeOptions();
            chrome_options.addArguments("--disable-notifications");
            driver = new ChromeDriver(chrome_options);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.get("http://leaftaps.com/opentaps/control/main");
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            driver.findElement(By.id("labels")).click();

            File src = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./screenshot/dashboard.png"));
            reportStep("test case - Passed", "pass","dashboard.png");

        }catch (Exception e){
            File src = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./screenshot/failed.png"));
            reportStep("test case - Failed", "fail","failed.png");
        }

    }
    @AfterTest
    public void postCondition(){
        driver.close();
    }
}
