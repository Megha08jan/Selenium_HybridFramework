package hybridFramework.uiautomation.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {

	
	public String[][] readdata(String path,String sheetname) throws IOException{

		File file = new File(path);
		FileInputStream fileinputstream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileinputstream);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFRow row ;
		XSSFCell cell ;

		String[][] dataset = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i =1;i<=sheet.getLastRowNum();i++){

			row = sheet.getRow(i);

			for(int j=0; j<row.getLastCellNum();j++){

				cell = row.getCell(j);

				dataset[i-1][j]= cell.getStringCellValue();
				System.out.print(i-1 + " "+ j);	
				System.out.println(" ");
				System.out.print(dataset[i-1][j]);
			}


		}

		return dataset;

	}



}
