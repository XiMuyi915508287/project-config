package com.project.config.export.excel;

import com.project.config.export.excel.convert.ExcelCellConverter;
import com.project.config.export.excel.convert.ExcelDateConverter;
import com.project.config.export.excel.convert.ExcelDoubleConverter;
import com.project.config.export.excel.convert.ExcelFloatConverter;
import com.project.config.export.excel.convert.ExcelLanguageConverter;
import com.project.config.export.excel.convert.ExcelListConverter;
import com.project.config.export.excel.convert.ExcelNumberConverter;
import com.project.config.export.excel.convert.ExcelStringConverter;
import com.project.config.export.excel.convert.IExcelCellConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelCellConvertUtil {

	private static final Map<String, IExcelCellConverter> converters = new ConcurrentHashMap<>();

	static {
		addConverter(new ExcelStringConverter());
		addConverter(new ExcelDateConverter());
		addConverter(new ExcelDoubleConverter());
		addConverter(new ExcelFloatConverter());
		addConverter(new ExcelNumberConverter());
		addConverter(new ExcelLanguageConverter());
	}

	private static void addConverter(ExcelCellConverter cellConverter){
		converters.put(cellConverter.getType(), cellConverter);
		ExcelListConverter listConverter = new ExcelListConverter(cellConverter);
		converters.put(listConverter.getType(), listConverter);
	}

	public static Object readConfigValue(XSSFCell xssfCell, ExcelFieldConfig fieldConfig) throws Exception {
		IExcelCellConverter converter = getConverter(fieldConfig.getType());
		if (converter == null){
			throw new UnsupportedOperationException("不支持类型:" + fieldConfig.getType());
		}
		return converter.convert2ClassValue(xssfCell);
	}

	public static String readString(XSSFCell xssfCell) throws Exception {
		IExcelCellConverter converter = getConverter("string");
		return (String) converter.convert2ClassValue(xssfCell);
	}

	private static IExcelCellConverter getConverter(String type){
		return converters.get(type);
	}
}