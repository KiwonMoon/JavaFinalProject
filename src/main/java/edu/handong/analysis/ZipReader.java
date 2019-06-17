package edu.handong.analysis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {
	
	public ArrayList<String> readFileInZip(String path) {
		
		ZipFile zipFile;
		ArrayList<String> lines= new ArrayList<String>();
		
		try {
			lines.add("Student ID" + "," + "제목" + "," + "요약문 (300자 내외)" + "," + "\"핵심어 (keyword,쉽표로 구분)\"" + "," + "조회날짜" + "," + "실제자료조회 출처 (웹자료링크)" + "," + "원출처 (기관명 등)" + "," + "제작자 (Copyright 소유처)");
			
			for(int i = 1; i <= 5; i++) {
				String paths = path + "000" + i + ".zip";
				
				zipFile = new ZipFile(paths);
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
				
				while(entries.hasMoreElements()) {
					ZipArchiveEntry entry = entries.nextElement();
					InputStream stream = zipFile.getInputStream(entry);
					
					ExcelReader myReader = new ExcelReader();
					
					for(String lineAndId: myReader.getData(stream, true)) {
						lineAndId = "000" + i + "," + lineAndId;
						
						lines.add(lineAndId);
						
						System.out.println(lineAndId);
					}
					break;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
