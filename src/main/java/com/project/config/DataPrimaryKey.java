package com.project.config;

import java.util.Objects;

public class DataPrimaryKey {

	private final int primaryId;
	private final int secondaryId;

	public DataPrimaryKey(int primaryId, int secondaryId) {
		this.primaryId = primaryId;
		this.secondaryId = secondaryId;
	}

	public int getPrimaryId() {
		return primaryId;
	}

	public int getSecondaryId() {
		return secondaryId;
	}

	public long getLongKey(){
		return ((long)primaryId) << 32 | secondaryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DataPrimaryKey that = (DataPrimaryKey) o;
		return primaryId == that.primaryId &&
				secondaryId == that.secondaryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(primaryId, secondaryId);
	}
}
