package com.project.config.export.excel;

import jodd.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.List;

public class ExcelFieldConfig {

	public static final int Count = 4;

	private final int index;
	private final boolean isPrimaryKey;
	private final String type;
	private final String export;
	private final String name;
	private final String annotation;

	public ExcelFieldConfig(int index, boolean isPrimaryKey, String type, String export, String name, String annotation) {
		this.index = index;
		this.isPrimaryKey = isPrimaryKey;
		this.type = type;
		this.export = export;
		this.name = name;
		this.annotation = annotation;
	}

	public int getIndex() {
		return index;
	}

	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public String getType() {
		return type;
	}

	public String getExport() {
		return export;
	}

	public String getName() {
		return name;
	}

	public String getAnnotation() {
		return annotation;
	}

	public static List<ExcelFieldConfig> readExcelSheet(XSSFSheet sheet, int primaryKeyIndex, int firstIndex, int lastIndex) throws Exception {
		XSSFRow firstXssRow = sheet.getRow(firstIndex - 1);
		int numberOfCells = firstXssRow.getLastCellNum();
		List<ExcelFieldConfig> fieldConfigs = new ArrayList<>();
		for (int number = 0; number < numberOfCells; number++) {
			String name = ExcelCellConvertUtil.readString(firstXssRow.getCell(number));
			if (StringUtil.isEmpty(name)){
				continue;	//空列
			}
			List<String> nameList = new ArrayList<>();
			for (int index = firstIndex - 1; index < lastIndex; index++) {
				XSSFRow xssfRow = sheet.getRow(index);
				nameList.add(ExcelCellConvertUtil.readString(xssfRow.getCell(number)));
			}
			boolean isPrimaryKey = false;
			XSSFCell cell = sheet.getRow(primaryKeyIndex - 1).getCell(number);
			if (cell != null){
				String readString = ExcelCellConvertUtil.readString(cell);
				if (!StringUtil.isEmpty(readString)){
					if (readString.trim().equals("PrimaryKey")){
						isPrimaryKey = true;
					}
					else {
						throw new RuntimeException("主键名字错误:" + readString);
					}
				}
			}
			ExcelFieldConfig fieldConfig = new ExcelFieldConfig(number, isPrimaryKey, nameList.get(0), nameList.get(1), nameList.get(2), nameList.get(3));
			fieldConfigs.add(fieldConfig);
		}
		return fieldConfigs;
	}
}
