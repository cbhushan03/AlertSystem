package com.cbt.webclient.model;

import java.util.Date;

public class AlertMonitor {
	private Integer jobid;
	private String hostname;
	private String srcpath;
	private boolean checkflag = false;
	private String descpath;
	private String fileextm;
	private String emailrecpt;
	private Date CreationDate = new Date();
	private String CreatedBy = "Admin";
	public Integer getJobid() {
		return jobid;
	}
	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}
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
	public boolean isCheckflag() {
		return checkflag;
	}
	public void setCheckflag(boolean checkflag) {
		this.checkflag = checkflag;
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
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public AlertMonitor(Integer jobid, String hostname, String srcpath, boolean checkflag, String descpath,
			String fileextm, String emailrecpt, Date creationDate, String createdBy) {
		super();
		this.jobid = jobid;
		this.hostname = hostname;
		this.srcpath = srcpath;
		this.checkflag = checkflag;
		this.descpath = descpath;
		this.fileextm = fileextm;
		this.emailrecpt = emailrecpt;
		CreationDate = creationDate;
		CreatedBy = createdBy;
	}
	
	public AlertMonitor() {
		
	}
	@Override
	public String toString() {
		return "AlertMonitor [jobid=" + jobid + ", hostname=" + hostname + ", srcpath=" + srcpath + ", checkflag="
				+ checkflag + ", descpath=" + descpath + ", fileextm=" + fileextm + ", emailrecpt=" + emailrecpt
				+ ", CreationDate=" + CreationDate + ", CreatedBy=" + CreatedBy + "]";
	}
	
	
}
