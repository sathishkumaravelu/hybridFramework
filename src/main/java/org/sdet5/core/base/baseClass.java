package org.sdet5.core.base;

import org.sdet5.utils.ReadExcel;
import org.sdet5.utils.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class baseClass extends Reporter {
    @DataProvider(name = "fetchData")
    public Object[][] fetchData() throws IOException {
        return ReadExcel.readExcelData(excelFileName);
    }

    @BeforeMethod
    public void preCondition() {
        System.out.println("common preCondition");
    }


}
