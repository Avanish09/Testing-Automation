package com.emailAutomation;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.EmailAttachment;

import java.io.File;
import java.util.Properties;

public class email {

    public static void sendemail4(String TC, File fl, String url) {
    	
    	Multipart multipart = new MimeMultipart();
       

        final String username = "Sender Email";
        final String password = "Sender email password";
        EmailAttachment attachment = new EmailAttachment();		
		  attachment.setPath("" + fl);
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Sender Email"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("Recipient email")
            );
           
            message.setSubject("Alert -- " +TC +" -- Alert");
            message.setText("" +fl +" \n" +url);
            //message.setContent(attachment, "Screenshot");
            //message.ATTACHMENT(attachment);
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}





