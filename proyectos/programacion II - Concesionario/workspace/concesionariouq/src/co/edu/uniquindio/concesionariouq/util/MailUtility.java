package co.edu.uniquindio.concesionariouq.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

class MailUtility {
	public static class MultiMsg extends MimeMultipart {
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

	static StringBuilder generarHeader(String msg) {
		StringBuilder header = new StringBuilder();
		header.append("<center>");
		header.append("<h1 style=\"font-family:'Open Sans',sans-serif;font-size:30px;\">");
		header.append(msg);
		header.append("</h1>");
		header.append("</center>");
		return header;
	}

	static StringBuilder generarHeaderImagenConcesionario() {
		StringBuilder imgConcesionario = new StringBuilder();
		imgConcesionario.append("<center>");
		imgConcesionario.append("	<img ");
		imgConcesionario.append("src=\"https://i.ibb.co/7y9XhLN/Logo-concesionariouq.png\" ");
		imgConcesionario.append("alt=\"Logo-concesionariouq\" ");
		imgConcesionario.append("border=\"0\" ");
		imgConcesionario.append("style=");
		imgConcesionario.append("\"width: 20vw; ");
		imgConcesionario.append("min-width: 330px;");
		imgConcesionario.append("\">");
		imgConcesionario.append("</center>");
		return imgConcesionario;
	}

	static StringBuilder generarFooter() {
		StringBuilder sbMsg4Final = new StringBuilder();
		sbMsg4Final.append("<p style=\"font-family:'Open Sans',sans-serif;font-size:15px;\">");
		sbMsg4Final.append("<br>Atentamente,");
		sbMsg4Final.append("<br>");
		sbMsg4Final.append("<br><i>Equipo Amador y Perdomo</i>");
		sbMsg4Final.append("<br><b>ConcesionarioUQ</b>");
		sbMsg4Final.append("</p>");
		return sbMsg4Final;
	}

	static void agregarPropiedadesCorreo(Properties prop) {
		prop.put("mail.smtp.auth", true); //$NON-NLS-1$
		prop.put("mail.smtp.starttls.enable", true); //$NON-NLS-1$
		prop.put("mail.smtp.port", "587"); //$NON-NLS-1$ //$NON-NLS-2$
		prop.put("mail.smtp.host", "smtp.gmail.com"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	static Session generarSesion(String mailFrom, String mailPassword, Properties prop) {
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, mailPassword);
			}
		});
		return session;
	}

	final static String getMailName() {
		return desencriptar(MailUtility.getMailInfo()).toString().split("-")[0];
	}

	final static String getPassword() {
		return desencriptar(MailUtility.getMailInfo()).toString().split("-")[1];
	}

	final static String getMailInfo() {
		String pass = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("src/co/edu/uniquindio/concesionariouq/util/mailInfo.dat"));
			StringBuilder sb = (StringBuilder) ois.readObject();
			pass = sb.toString();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pass;
	}

	final static StringBuilder desencriptar(String msg) {
		StringBuilder stringBuilder = new StringBuilder();
		msg.codePoints().map(num -> num - 1).mapToObj(num -> Character.toString((char) num))
				.forEach(stringBuilder::append);
		return stringBuilder;
	}

	static final String MAILFROM = getMailName();
	static final String PASSWORD = getPassword();
}
