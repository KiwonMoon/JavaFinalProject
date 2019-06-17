package edu.handong.analysis;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public ArrayList<String> getData(InputStream is, boolean removeHeader) {
		ArrayList<String> values = new ArrayList<String>();
		//String line = "";
		
		try (InputStream inp = is) {
		    //InputStream inp = new FileInputStream("workbook.xlsx");
		    
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        for (int rowIndex = sheet.getFirstRowNum() + 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
		        	//String line = null;
		        	String line = "";
		        	Row row = sheet.getRow(rowIndex);
		        	
		        	for(int cellIndex = row.getFirstCellNum(); cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
		        		Cell cell = row.getCell(cellIndex);
		        		
		        		try {
		        			line = line + "\"" + cell.getStringCellValue() +  "\"";
		        			
		        		} catch(IllegalStateException e) {
		        			line = line + "\"" + cell.getNumericCellValue() + "\"";
		        		}
		        		
		        		if (cellIndex != row.getPhysicalNumberOfCells() -1) { //getLastCellNum()
		        			line = line + ",";
		        			//line = "\"" + line + "," + "\"";
		        		}
		        		
		        	}
		        	values.add(line);
		        }
		        
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return values;
	}
	
}
