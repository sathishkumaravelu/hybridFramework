package referenceCode;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadData {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook("data/DataFile.xlsx");

        XSSFSheet sheet = wb.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();

        for (int i = 1; i <= lastRowNum; i++) {
            for (int j = 0; j < lastCellNum; j++) {
                String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                System.out.println(stringCellValue);
            }
            wb.close();
        }

    }
}
