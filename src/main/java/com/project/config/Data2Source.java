package com.project.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Data2Source<T> extends DataSource<T>{

	private final Function<T, Integer> primaryKey;
	private final Function<T, Integer> secondKey;

	private List<T> primaryDataList;
	private Map<Integer, List<T>> dataListMap;
	private Map<DataPrimaryKey, T> primaryDataMap;

	public Data2Source(String name, Function<T, Integer> primaryKey, Function<T, Integer> secondKey) {
		super(name);
		this.primaryKey = primaryKey;
		this.secondKey = secondKey;
	}

	@Override
	protected void loadJsonDataList(List<T> dataList) {
		Map<DataPrimaryKey, T> primaryDataMap = new HashMap<>(dataList.size());
		for (T data : dataList) {
			DataPrimaryKey primaryKey = new DataPrimaryKey(this.primaryKey.apply(data), secondKey.apply(data));
			primaryDataMap.put(primaryKey, data);
		}
		Map<Integer, List<T>> groupByKey = new HashMap<>();
		for (T data : dataList) {
			List<T> computeIfAbsent = groupByKey.computeIfAbsent(this.primaryKey.apply(data), key -> new ArrayList<>());
			computeIfAbsent.add(data);
		}
		for (Map.Entry<Integer, List<T>> entry : groupByKey.entrySet()) {
			entry.getValue().sort(Comparator.comparingInt(secondKey::apply));
			dataListMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
		}
		List<T> primaryDataList = primaryDataMap.entrySet().stream().sorted(Comparator.comparingLong(entry -> entry.getKey().getLongKey()))
				.map(Map.Entry::getValue).collect(Collectors.toList());

		this.primaryDataMap = primaryDataMap;
		this.dataListMap = dataListMap;
		this.primaryDataList = Collections.unmodifiableList(primaryDataList);
	}

	public List<T> getDataList() {
		return primaryDataList;
	}

	public List<T> getDataList(int primaryId) {
		return dataListMap.get(primaryId);
	}

	public T getData(int primaryId, int secondaryId) {
		return getData(new DataPrimaryKey(primaryId, secondaryId));
	}

	public T getData(DataPrimaryKey primaryKey) {
		return primaryDataMap.get(primaryKey);
	}
}
