package com.project.config.export.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.game.common.config.ConfigUtil;
import com.game.common.config.IConfig;
import jodd.util.StringUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelExportUtil {

	/**
	 * excel 配置表导出成Json文件、Java类文件
	 * @param fileName
	 * @param configName
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static void excel2JsonAndClass(String fileName, String configName) throws IOException, InvalidFormatException {
		File file = new File(fileName);
		if (!file.exists()){
			throw new RuntimeException("不存在文件:" + fileName);
		}
		IConfig config = ConfigUtil.loadConfig(configName);
		excel2JsonAndClass(file, config);
	}

	/**
	 * excel 配置表导出成Json文件、Java类文件
	 * @param file
	 * @param config
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private static void excel2JsonAndClass(File file, IConfig config) throws IOException, InvalidFormatException {
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		int firstIndex = config.getInt("fields.firstIndex");
		int lastIndex = config.getInt("fields.lastIndex");
		if (lastIndex - firstIndex + 1 != ExcelFieldConfig.Count) {
			throw new RuntimeException(String.format("字段信息行数错误:%s-%s", firstIndex, lastIndex));
		}
		String jsonDirectory = config.getString("jsonPath");
		File directory = new File(jsonDirectory);
		if (directory.exists()){
			if (!directory.isDirectory()){
				throw new RuntimeException("不是目录类型:" + jsonDirectory);
			}
		}
		else {
			if (!directory.mkdirs()){
				throw new RuntimeException("创建目录失败:" + jsonDirectory);
			}
		}
		for (int index = 0; index < numberOfSheets; index++) {
			XSSFSheet sheet = workbook.getSheetAt(index);
			String sheetName = sheet.getSheetName();
			if (sheetName.indexOf("export_") != 0){
				continue;
			}
			int numberOfRows = sheet.getLastRowNum() + 1;
			if (numberOfRows < lastIndex){
				throw new RuntimeException(String.format("页签: %s.%s 行数小于%s,格式错误", file.getName(), sheetName, lastIndex));
			}
			String jsonFileName = ExcelCellUtil.readString(sheet.getRow(0).getCell(0));
			int primaryIndex = config.getInt("fields.primaryIndex");
			List<ExcelFieldConfig> fieldConfigs = ExcelFieldConfig.readExcelSheet(sheet, primaryIndex, firstIndex, lastIndex);
			excel2Json(sheet, lastIndex, fieldConfigs, jsonFileName, jsonDirectory);
		}
	}

	/**
	 * 导出Json文件
	 * @param sheet
	 * @param firstIndex
	 * @param fieldConfigs
	 * @param jsonFileName
	 * @param jsonDirectory
	 * @throws IOException
	 */
	private static void excel2Json(XSSFSheet sheet, int firstIndex, List<ExcelFieldConfig> fieldConfigs, String jsonFileName, String jsonDirectory) throws IOException {
		int numberOfRows = sheet.getLastRowNum() + 1;
		List<List<String>> excelStringList = new ArrayList<>();
		for (int rowIndex = firstIndex; rowIndex < numberOfRows; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			if (row == null){
				continue;	//存在空行
			}
			List<String> stringList = new ArrayList<>();
			for (ExcelFieldConfig fieldConfig : fieldConfigs) {
				XSSFCell cell = row.getCell(fieldConfig.getIndex());
				String readString = ExcelCellUtil.readString(cell);
				if (fieldConfig.getIndex() == 0 && StringUtil.isEmpty(readString)){
					stringList.clear();
					break;
				}
				else {
					stringList.add(readString);
				}
			}
			if (!stringList.isEmpty()){
				excelStringList.add(stringList);
			}
		}

		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < excelStringList.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			List<String> stringList = excelStringList.get(i);
			for (ExcelFieldConfig fieldConfig : fieldConfigs) {
				jsonObject.put(fieldConfig.getName(), stringList.get(fieldConfig.getIndex()));
			}
			if (i > 0){
				builder.append(",");
			}
			builder.append("\n\t").append(JSONArray.toJSONString(jsonObject));
		}
		builder.append("\n]");
		File file = new File(String.format("%s/%s.json", jsonDirectory, jsonFileName));
		FileWriter writer = new FileWriter(file);
		writer.append(builder.toString());
		writer.flush();
		writer.close();
		String absolutePath = file.getAbsolutePath();
		System.out.println("导出JSON文件成功: " + absolutePath);
	}
}
