package com.cbt.webapp.model;

public class Alert {
	private String hostname;
	private String srcpath;
	private String descpath;
	private String fileextm;
	private String emailrecpt;
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getSrcpath() {
		return srcpath;
	}
	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}
	public String getDescpath() {
		return descpath;
	}
	public void setDescpath(String descpath) {
		this.descpath = descpath;
	}
	public String getFileextm() {
		return fileextm;
	}
	public void setFileextm(String fileextm) {
		this.fileextm = fileextm;
	}
	public String getEmailrecpt() {
		return emailrecpt;
	}
	public void setEmailrecpt(String emailrecpt) {
		this.emailrecpt = emailrecpt;
	}
	
	public Alert(String hostname, String srcpath, String descpath, String fileextm, String emailrecpt) {
		super();
		this.hostname = hostname;
		this.srcpath = srcpath;
		this.descpath = descpath;
		this.fileextm = fileextm;
		this.emailrecpt = emailrecpt;
	}
	
	public Alert() {
		
	}
	@Override
	public String toString() {
		return "Alert [hostname=" + hostname + ", srcpath=" + srcpath + ", descpath=" + descpath + ", fileextm="
				+ fileextm + ", emailrecpt=" + emailrecpt + "]";
	}
	
	
	
}
