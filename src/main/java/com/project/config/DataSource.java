package com.project.config;

import com.alibaba.fastjson.JSON;

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
		List<T> dataList = JSON.parseArray(jsonString, getJsonClass());
		loadJsonDataList(dataList);
	}

	protected abstract Class<T> getJsonClass();

	protected abstract void loadJsonDataList(List<T> dataList);
}
