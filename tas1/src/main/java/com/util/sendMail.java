package com.util;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendMail {

	private String sender = "user@404NotFoundDrivingSchool.com";
	private String receivers = "giotto.chow@gmail.com,user@404NotFoundDrivingSchool.com";
	private String subject = "testing";
	private String body = "testing";
	private String attachmentPath = "na";

	public sendMail() throws Exception {
		boolean bool = false;
		Properties localProperties = System.getProperties();
		localProperties.put("mail.smtp.host", "404NotFoundDrivingSchool.com");

		Session localSession = Session
				.getDefaultInstance(localProperties, null);
		localSession.setDebug(bool);
		try {
			MimeMessage localMimeMessage = new MimeMessage(localSession);
			localMimeMessage.setFrom(new InternetAddress(sender));
			InternetAddress[] arrayOfInternetAddress = InternetAddress
					.parse(receivers);
			localMimeMessage.setRecipients(Message.RecipientType.TO,
					arrayOfInternetAddress);
			localMimeMessage.setSubject(subject, "Big5");
			localMimeMessage.setSentDate(new Date());

			MimeMultipart localMimeMultipart = new MimeMultipart();
			Object localObject;
			if (!body.equalsIgnoreCase("na")) {
				localObject = new MimeBodyPart();
				((MimeBodyPart) localObject).setText(body, "Big5");
				localMimeMultipart.addBodyPart((BodyPart) localObject);
			}
			if (!attachmentPath.equalsIgnoreCase("na")) {
				localObject = new FileDataSource(attachmentPath);

				MimeBodyPart localMimeBodyPart = new MimeBodyPart();
				localMimeBodyPart.setDataHandler(new DataHandler(
						(DataSource) localObject));
				int i = attachmentPath.lastIndexOf(File.separator);
				String str2 = attachmentPath.substring(i + 1,
						attachmentPath.length());
				localMimeBodyPart.setFileName(str2);
				localMimeMultipart.addBodyPart(localMimeBodyPart);
			}
			localMimeMessage.setContent(localMimeMultipart);

			Transport.send(localMimeMessage);
		} catch (Exception localException) {
			throw localException;
		}

	}

	public static void main(String[] args) throws Exception {
		new sendMail();
	}
}
