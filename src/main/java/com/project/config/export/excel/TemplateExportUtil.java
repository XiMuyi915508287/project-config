package com.project.config.export.excel;

import com.game.common.config.IConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Map;

public class TemplateExportUtil {

	public static void create(String templateName, String exportName, Map<String, Object> paramMap) throws IOException, TemplateException {
		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		URL resource = ExcelExportUtil.class.getResource(templateName);
		File resourceFile = new File(resource.getPath());
		configuration.setDirectoryForTemplateLoading(resourceFile.getParentFile());
		configuration.setClassicCompatible(false);
		Template template = configuration.getTemplate(resourceFile.getName());

		File file = new File(exportName);
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				throw new RuntimeException("创建文件夹失败：" + file.getParentFile().getAbsolutePath());
			}
		}
		Writer writer = new FileWriter(file);
		template.process(paramMap, writer);
		writer.flush();
		writer.close();
	}

	public static String checkAndGetDirectory(IConfig config, String path){
		String jsonDirectory = config.getString(path);
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
		return jsonDirectory;
	}
}
