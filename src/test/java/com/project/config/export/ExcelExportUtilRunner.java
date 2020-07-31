package com.project.config.export;

import com.project.config.export.excel.ExcelExportUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;

public class ExcelExportUtilRunner {

	@Test
	public void exportJson() throws IOException, InvalidFormatException {
		String fileName = "C:\\ProjectG\\pjg-product\\AExcel\\develop\\excel\\activity193.xlsx";
		String configName = "D:\\demo\\project-config\\src\\main\\resources\\export\\excel2json.conf";
		ExcelExportUtil.excel2JsonAndClass(fileName, configName);
	}
}
