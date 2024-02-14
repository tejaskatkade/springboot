package com.mail.app;

import java.util.Properties;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		System.out.println("Hello world");
		String message ="happy birthday";
		String subject ="wish you";
		String to ="tejaskatkade44@gamil.com";
		String from ="katkadetejas11@gamil.com";

		sendEmail(message,subject,to,from);
	}

	public static void sendEmail(String message, String subject,String to,String from){
		// variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("Propertiesvv:"+properties);

		//Setting imp info to properties object

		//host set (host uses this key to set prop)
		properties.put("mail.smtp.host","465");
		properties.put("mail.smtp.ssl.enable",true);
		properties.put("mail.smtp.auth",true);

		//step 1: To get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("katkadetejas11@gamil.com","********");

			}
		});	

		session.setDebug(true);
		
		//step 2 : Compose the message [text, media]
		MimeMessage m = new MimeMessage(session);

		//from emial
		try {
			m.setFrom(from);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			//adding recipiant
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);

			//step 3: send message using Transport class
			Transport.send(m);
			System.out.println("sent successfully..");

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {

			e.printStackTrace();
		}




		

		
		
	}

}
