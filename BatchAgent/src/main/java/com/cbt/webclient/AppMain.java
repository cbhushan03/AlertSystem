package com.cbt.webclient;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cbt.webclient.dao.JdbcDaoImpl;
import com.cbt.webclient.email.EmailClient;
import com.cbt.webclient.model.AlertMonitor;
import com.cbt.webclient.model.EmailTemplet;
import com.cbt.webclient.model.FileDetails;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
		
		JdbcDaoImpl JdbcDaoImpl =context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		EmailTemplet templet = context.getBean("emailTemplet", EmailTemplet.class);
		EmailClient client = context.getBean("emailClient", EmailClient.class);
		
		AlertMonitor alertMonitor = JdbcDaoImpl.getAlertDetail(Integer.parseInt(args[0]));
		
		System.out.println(alertMonitor.toString());
		
		String messsageBody="";
		
		ArrayList<FileDetails> fileListDetails = getListFiles(alertMonitor.getSrcpath());	
		if(fileListDetails !=null) {
			
			messsageBody = templet.createMessageBody(fileListDetails, alertMonitor.getHostname(), alertMonitor.getSrcpath());
			
			templet.setEml_recipient(alertMonitor.getEmailrecpt());
			templet.setMessage_body(messsageBody);
			templet.setEml_subject("This is a test "+new Date().toLocaleString());
			
		}
		

		client.createSession();
		
		
		
		//System.out.println(JdbcDaoImpl.getEmpCount());
	}
	
	public static ArrayList<FileDetails> getListFiles(String path) {
		
		ArrayList<FileDetails> listFiles = new ArrayList<FileDetails>();
		
		
		File sourcepath = new File(path);
		Collection<File> files = FileUtils.listFiles(sourcepath, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			Date lastModified = new Date(file.lastModified());
			listFiles.add(new FileDetails(file.getAbsolutePath(), lastModified.toLocaleString()));
			
		}
		return listFiles;
	}

}
