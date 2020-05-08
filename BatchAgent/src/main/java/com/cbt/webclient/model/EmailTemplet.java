package com.cbt.webclient.model;

import java.util.ArrayList;

public class EmailTemplet {
	private String eml_recipient;
	private String message_body;
	
	private String eml_subject;
	
	public String getEml_subject() {
		return eml_subject;
	}
	
	public void setEml_subject(String eml_subject) {
		this.eml_subject = eml_subject;
	}
	public String getEml_recipient() {
		return eml_recipient;
	}
	public void setEml_recipient(String eml_recipient) {
		this.eml_recipient = eml_recipient;
	}
	public String getMessage_body() {
		return message_body;
	}
	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}
	
	public EmailTemplet(String eml_recipient, String message_body, String eml_subject) {
		super();
		this.eml_recipient = eml_recipient;
		this.message_body = message_body;
		this.eml_subject = eml_subject;
	}
	
	public EmailTemplet() {
		
	}
	
	public String createMessageBody(ArrayList<FileDetails> fileDetails,String hostname,String sourceDir) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>");
		buffer.append("<head>");
		buffer.append("<style>");
		
		buffer.append(" #filetable { ");
		buffer.append("   font-family: 'Trebuchet MS', Arial, Helvetica, sans-serif; ");
		buffer.append("   border-collapse: collapse; ");
		buffer.append("   width: 100%; ");
		buffer.append(" } ");

		buffer.append(" #filetable td, #filetable th { ");
		buffer.append("   border: 1px solid #ddd; ");
		buffer.append("   padding: 8px; ");
		buffer.append(" } ");
		buffer.append("  ");
		buffer.append(" #filetable tr:nth-child(even){background-color: #f2f2f2;} ");
		buffer.append("  ");
		buffer.append(" #filetable tr:hover {background-color: #ddd;} ");

		buffer.append(" #filetable th { ");
		buffer.append("   padding-top: 12px; ");
		buffer.append("   padding-bottom: 12px; ");
		buffer.append("   text-align: left; ");
		buffer.append("   background-color: #4CAF50; ");
		buffer.append("   color: white; ");
		buffer.append(" } ");
		
		buffer.append("</style>");
		buffer.append("</head>");
		buffer.append("<body>");
		
		buffer.append("<p>This is an auto-generated email from Web Client system from host "+hostname+" system</p>");
		buffer.append("<p>List of files still available in directories are mention below.</p>");
		buffer.append("<table id='filetable'>");
		buffer.append("	<th> List of files</th>");
		
		for(FileDetails fds:fileDetails) {
			buffer.append("	<tr><td>"+fds.getFiledate()+" "+fds.getFilename()+"</td></tr>");
		}
		
		buffer.append("</table>");
		
		
		buffer.append("</body>");
		buffer.append("</html>");
		
		return buffer.toString();
	}
	
	
}
