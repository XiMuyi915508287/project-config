package com.project.config;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;

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
	public void loadJson(String jsonString) {
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
