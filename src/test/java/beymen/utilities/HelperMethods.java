package beymen.utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;

public class HelperMethods {
    public String getProductName(int row) throws IOException {
        String excelFileName = "src/test/resources/files/products.xls";
        FileInputStream fileInput = new FileInputStream(new File(excelFileName));

        Workbook wb = WorkbookFactory.create(new PushbackInputStream(fileInput));


            String tabName = wb.getSheet("products_sheet").getRow(row).getCell(0).toString();

        fileInput.close();
        return tabName;
    }

    public void writeDataToTxt(String text) {
        File file = new File("src/test/resources/files/productsInfo.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
