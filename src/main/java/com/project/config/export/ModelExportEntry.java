package com.project.config.export;

import java.util.List;

public class ModelExportEntry {

	private final String filename;
	private final String javaClassName;
	private final List<ModelExportField> fieldList;
	private final String annotation;

	public ModelExportEntry(String filename, String javaClassName, List<ModelExportField> fieldList, String annotation) {
		this.filename = filename;
		this.javaClassName = javaClassName;
		this.fieldList = fieldList;
		this.annotation = annotation;
	}

	public String getFilename() {
		return filename;
	}

	public String getJavaClassName() {
		return javaClassName;
	}

	public List<ModelExportField> getFieldList() {
		return fieldList;
	}

	public String getAnnotation() {
		return annotation;
	}
}
