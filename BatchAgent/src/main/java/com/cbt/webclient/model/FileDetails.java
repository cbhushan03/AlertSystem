package com.cbt.webclient.model;

public class FileDetails {
	private String filename;
	private String filedate;
	
	public FileDetails() {
		
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiledate() {
		return filedate;
	}

	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}

	public FileDetails(String filename, String filedate) {
		super();
		this.filename = filename;
		this.filedate = filedate;
	}
	
	
}
