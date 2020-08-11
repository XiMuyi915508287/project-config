package com.project.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Data1Source<T> extends DataSource<T> {

	private final Function<T, Integer> primaryKey;
	private List<T> dataList;
	private Map<Integer, T> dataMap;

	public Data1Source(String name, Function<T, Integer> primaryKey) {
		super(name);
		this.primaryKey = primaryKey;
		this.dataList = new ArrayList<>();
		this.dataMap = new HashMap<>();
	}

	@Override
	protected void loadJsonDataList(List<T> dataList) {
		dataList.sort(Comparator.comparingInt(primaryKey::apply));
		this.dataMap = Collections.unmodifiableMap(dataList.stream().collect(Collectors.toMap(primaryKey, data -> data)));
		this.dataList = Collections.unmodifiableList(dataList);
	}

	public List<T> getDataList() {
		return dataList;
	}

	public Map<Integer, T> getDataMap() {
		return dataMap;
	}

	public T getData(Integer id) {
		return dataMap.get(id);
	}

	public T firstData() {
		return dataList.isEmpty() ? null : dataList.get(0);
	}

	public T lastData() {
		return dataList.isEmpty() ? null : dataList.get(dataList.size() - 1);
	}
}
