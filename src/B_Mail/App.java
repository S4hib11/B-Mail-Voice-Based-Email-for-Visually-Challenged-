package B_Mail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import B_Mail.To;
import B_Mail.login;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

public class App {
	public static void mail() {
		try {
			String host = "smtp.gmail.com";

			String user = login.email3;
			String password = login.pass3;
			String to = To.to;
			String from = login.emailsend;
			String subject = "sub.subject";
			String messagetxt = "Message.message";
			boolean sessionDebug = false;

			System.out.println(to);
			System.out.println(user);
			System.out.println(password);

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messagetxt);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

			System.out.println("Mail Sent Successfully");
			Sent ob = new Sent();
			ob.s();

			// Sent.send();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}
