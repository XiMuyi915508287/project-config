package com.project.config;

import java.io.IOException;

public interface IDataSource {

	String getName();

	void loadFile(String filePath) throws IOException;
}
