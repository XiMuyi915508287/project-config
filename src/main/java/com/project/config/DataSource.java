package com.project.config;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import jodd.io.FileUtil;
import jodd.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSource<T> implements IDataSource {

	private final String name;

	public DataSource(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void loadFile(String filePath) throws IOException {
		String[] readLines = FileUtil.readLines(filePath, "UTF-8");
		String jsonString = StringUtil.join(readLines, "\n");
		DefaultJSONParser parser = new DefaultJSONParser(jsonString, new ParserConfig(true));
		ArrayList<T> dataList = new ArrayList<>();
		parser.parseArray(getJsonClass(), dataList);
		parser.handleResovleTask(dataList);
		parser.close();
//		List<T> dataList = JSON.parseArray(jsonString, getJsonClass());
		loadJsonDataList(dataList);
	}

	protected abstract Class<T> getJsonClass();

	protected abstract void loadJsonDataList(List<T> dataList);
}
