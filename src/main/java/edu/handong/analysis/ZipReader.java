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
		ArrayList<String> result1 = new ArrayList<String>();
		
		try {
			result1.add("Student ID" + "," + "제목" + "," + "요약문 (300자 내외)" + "," + "\"핵심어 (keyword,쉽표로 구분)\"" + "," + "조회날짜" + "," + "실제자료조회 출처 (웹자료링크)" + "," + "원출처 (기관명 등)" + "," + "제작자 (Copyright 소유처)");
			
			for(int i = 1; i <= 5; i++) {
				String paths = path + "000" + i + ".zip";
				
				zipFile = new ZipFile(paths);
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
				
				while(entries.hasMoreElements()) {
					ZipArchiveEntry entry = entries.nextElement();
					InputStream stream = zipFile.getInputStream(entry);
					
					ExcelReader myReader = new ExcelReader();
					
					//CustomizedGenerics<String> genericLine = myReader.getData(stream, true);
					
					for(String lineAndId: myReader.getData(stream, true, 1)) {
						//String lineAndId = "";
						lineAndId = "000" + i + "," + lineAndId;
						
						result1.add(lineAndId);
						
						System.out.println(lineAndId);
					}
					break;
				}
				zipFile.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result1;
	}
	
public ArrayList<String> readFile2InZip(String path) {
		
		ZipFile zipFile;
		ArrayList<String> result2 = new ArrayList<String>();
		
		try {
			result2.add("Student ID" + "," + "제목(반드시 요약문 양식에 입력한 제목과 같아야 함.)" + "," + "표/그림 일련번호" + "," + "\"자료유형(표,그림,…)\"" + "," + "자료에 나온 표나 그림 설명(캡션)" + "," + "자료가 나온 쪽번호");
			
			for(int i = 1; i <= 5; i++) {
				String paths = path + "000" + i + ".zip";
				
				zipFile = new ZipFile(paths);
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
				
				while(entries.hasMoreElements()) {
					ZipArchiveEntry entry = entries.nextElement();
					InputStream stream = zipFile.getInputStream(entry);
					
					ExcelReader myReader = new ExcelReader();
					
					//CustomizedGenerics<String> genericLine = myReader.getData(stream, true);
					
					for(String lineAndId: myReader.getData(stream, true, 2)) {
						//String lineAndId = "";
						lineAndId = "000" + i + "," + lineAndId;
						
						result2.add(lineAndId);
						
						System.out.println(lineAndId);
					}
					break;
				}
				zipFile.close();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result2;
	}

}
