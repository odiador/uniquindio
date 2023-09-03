package co.edu.uniquindio.concesionariouq.util;

import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class MultiMsg extends MimeMultipart {
	public MultiMsg(String... cadenas) throws MessagingException {
		for (String cadaCadena : cadenas) {
			MimeBodyPart parte = new MimeBodyPart();
			parte.setContent(cadaCadena, "text/html; charset=utf-8");
			addBodyPart(parte);
		}
	}

	public MultiMsg(StringBuilder... stringBuilders) throws MessagingException {
		this(Arrays.stream(stringBuilders).map(sb -> sb.toString()).toArray(String[]::new));
	}
}
