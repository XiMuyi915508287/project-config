package com.project.config.export.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelCellUtil {

	public static String readString(XSSFCell cell){
		cell.setCellType(CellType.STRING);
		return cell.getStringCellValue();
	}
}
