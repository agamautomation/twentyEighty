package com.twentyeighty.utilities;

import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.twentyeighty.core.Wrapper;

import javax.activation.*;

public class SendEmailWithAttachment {

	Wrapper wrapperObj = new Wrapper();

	public void sendEmail() {

		String host = wrapperObj.readPropertyFile(new File("config.properties"), "host");
		
		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		properties.setProperty("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(properties);

		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(wrapperObj.readPropertyFile(new File("config.properties"), "from")));
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(wrapperObj.readPropertyFile(new File("config.properties"), "to")));
			message.setSubject("TestExecution Report");
			BodyPart messageBodyPart1 = new MimeBodyPart();
//			messageBodyPart1.setText("Please Go through the attached document");
			messageBodyPart1.setContent("<p>Please Go through the attached document.</p> <BR> <BR> <BR>Thanks<BR>XYZ abc","text/html");
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = "Automation_Report.html";

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Report Sent Successfully...");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
