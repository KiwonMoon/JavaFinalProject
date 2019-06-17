package edu.handong.analysis;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		
		try {
			
			for(int i = 1; i <= 2; i++) {
				String name = targetFileName + i + ".csv";
				

				File file = new File(name);
				FileOutputStream fos = new FileOutputStream(file);
				DataOutputStream dos = new DataOutputStream(fos);
				ArrayList<String> strArray = new ArrayList<>();
				
				//CustomizedGenerics<String> genericLine = myReader.getData(stream, true);
				
				for(String line: lines) {
					dos.write((line+"\n").getBytes());
					//dos.write((line+"").getBytes());
					
					if(!file.exists()) {
						file.getParentFile().mkdirs();
					}
				}
				dos.close();
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
