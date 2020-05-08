package com.cbt.webclient.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.cbt.webclient.model.EmailTemplet;

public class EmailClient {
	
		private String smtp_host;
		
		private String smpt_port;
		
		private String smpt_auth;
		
		private String smpt_tls_enable;
		
		private String smpt_from_address;
		
		private String smpt_email_password;
		
		@Autowired
		public EmailTemplet templet;
		
		public void createSession() {
			
			sendEmail( templet.getEml_recipient(), templet.getEml_subject(), templet.getMessage_body());

			
		}
		
		
		
		
		public void sendEmail(String toEmail, String subject, String body){

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS

	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(smpt_from_address,smpt_email_password);
	                    }
	                });

	        try {

	        	MimeMessage msg = new MimeMessage(session);
			      //set message headers
				
				  msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
				  msg.addHeader("format", "flowed"); msg.addHeader("Content-Transfer-Encoding",
				  "8bit");
				 

			      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			      msg.setSubject(subject, "UTF-8");

			      msg.setContent(body,"text/html");

			      msg.setSentDate(new Date());

			      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false)); 

	            Transport.send(msg);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		public String[] getRecipients(String recipients) {
			String[] recipientsList = recipients.split(";");
			return recipientsList;
		}

		
		public EmailClient() {
			
		}


		public String getSmtp_host() {
			return smtp_host;
		}

		public void setSmtp_host(String smtp_host) {
			this.smtp_host = smtp_host;
		}

		public String getSmpt_port() {
			return smpt_port;
		}

		public void setSmpt_port(String smpt_port) {
			this.smpt_port = smpt_port;
		}

		public String getSmpt_auth() {
			return smpt_auth;
		}

		public void setSmpt_auth(String smpt_auth) {
			this.smpt_auth = smpt_auth;
		}

		public String getSmpt_tls_enable() {
			return smpt_tls_enable;
		}

		public void setSmpt_tls_enable(String smpt_tls_enable) {
			this.smpt_tls_enable = smpt_tls_enable;
		}

		public String getSmpt_from_address() {
			return smpt_from_address;
		}

		public void setSmpt_from_address(String smpt_from_address) {
			this.smpt_from_address = smpt_from_address;
		}

		public String getSmpt_email_password() {
			return smpt_email_password;
		}

		public void setSmpt_email_password(String smpt_email_password) {
			this.smpt_email_password = smpt_email_password;
		}
		
		
		
}
