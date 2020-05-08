package com.cbt.webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlertMonitor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer jobid;
	private String hostname;
	private String srcpath;
	private boolean checkflag = false;
	private String descpath;
	private String fileextm;
	private String emailrecpt;
	private Date CreationDate = new Date();
	private String CreatedBy = "Admin";
	
	public AlertMonitor() {
		
	}
	
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
	
	
}
