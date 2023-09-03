package co.edu.uniquindio.concesionariouq.util;

import java.io.File;
import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class CorreoReporte extends MimeMessage {

	public CorreoReporte(Session session, String mailFrom, String mailTo, String nombre, String reporte, String info,
			File archivo) throws MessagingException, IOException {
		super(session);
		setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
		setFrom(new InternetAddress(mailFrom));
		setSubject(reporte + " | ConcesionarioUQ");

		StringBuilder header = MailUtility.generarHeader(reporte);
		StringBuilder imgConcesionario = MailUtility.generarHeaderImagenConcesionario();
		StringBuilder msg1Reporte = generarMensaje1Cuerpo(nombre, reporte, info);
		StringBuilder sbMsg4Final = MailUtility.generarFooter();

		MailUtility.MultiMsg multiMsg = new MailUtility.MultiMsg(header, imgConcesionario, msg1Reporte, sbMsg4Final);
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.attachFile(archivo);
		multiMsg.addBodyPart(mimeBodyPart);
		setContent(multiMsg);
	}

	private static StringBuilder generarMensaje1Cuerpo(String nombre, String reporte, String info) {
		StringBuilder sbMsg1Solicitud = new StringBuilder();
		sbMsg1Solicitud.append(
				"<p style=\"margin: 30px 0 20px 0;padding:20px 0 0 0;font-family:'Open Sans',sans-serif;font-size:15px;\">");
		sbMsg1Solicitud.append("Estimado/a, ");
		sbMsg1Solicitud.append("<b>");
		sbMsg1Solicitud.append(nombre);
		sbMsg1Solicitud.append("</b>");
		sbMsg1Solicitud.append("<br><br>");
		sbMsg1Solicitud.append("Adjunto encontrará el ");
		sbMsg1Solicitud.append(reporte);
		sbMsg1Solicitud.append(" de ConcesionarioUQ. Este informe contiene información detallada sobre");
		sbMsg1Solicitud.append(info);
		sbMsg1Solicitud.append(" y otros datos relevantes.<br>");
		sbMsg1Solicitud.append(
				"Para abrir el archivo adjunto, que se encuentra en formato PDF, asegúrese de tener instalado Adobe Acrobat Reader u otro programa compatible en su dispositivo.");
		sbMsg1Solicitud.append("Agradecemos su continuo apoyo y confianza en nuestros productos/servicios.");
		sbMsg1Solicitud.append("</p>");
		return sbMsg1Solicitud;
	}
}
