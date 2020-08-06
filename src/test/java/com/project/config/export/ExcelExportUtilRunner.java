package com.project.config.export;

import com.project.config.export.excel.ExcelExportUtil;
import org.junit.Test;

public class ExcelExportUtilRunner {

	@Test
	public void exportJson() throws Exception {
		String fileName = "C:\\ProjectG\\pjg-product\\AExcel\\develop\\excel\\activity193.xlsx";
		String configName = "D:\\demo\\project-config\\src\\main\\resources\\export\\excel2json.conf";
		ExcelExportUtil.excel2JsonAndClass(fileName, configName);
	}
}
