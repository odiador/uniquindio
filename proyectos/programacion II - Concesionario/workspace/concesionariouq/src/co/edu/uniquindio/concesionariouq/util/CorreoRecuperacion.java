package co.edu.uniquindio.concesionariouq.util;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CorreoRecuperacion extends MimeMessage {

	public CorreoRecuperacion(Session session, String mailFrom, String mailTo, String nombre, String codigo)
			throws MessagingException, IOException {
		super(session);
		setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
		setFrom(new InternetAddress(mailFrom));
		setSubject("¿Olvidaste tu contrasena? | ConcesionarioUQ");

		StringBuilder header = MailUtility.generarHeader("¿Olvidaste tu contraseña?");
		StringBuilder imgConcesionario = MailUtility.generarHeaderImagenConcesionario();
		StringBuilder sbMsg1Solicitud = generarMensaje1Cuerpo(nombre);
		StringBuilder sbMsg2TablaCodigo = generarMensajeCodigo(codigo);
		StringBuilder sbMsg3Instrucciones = generarMensaje2Cuerpo();
		StringBuilder sbMsg4Final = MailUtility.generarFooter();

		setContent(new MailUtility.MultiMsg(header, imgConcesionario, sbMsg1Solicitud, sbMsg2TablaCodigo, sbMsg3Instrucciones,
				sbMsg4Final));
	}

	private static StringBuilder generarMensaje1Cuerpo(String nombre) {
		StringBuilder sbMsg1Solicitud = new StringBuilder();
		sbMsg1Solicitud.append(
				"<p style=\"margin: 30px 0 20px 0;padding:20px 0 0 0;font-family:'Open Sans',sans-serif;font-size:15px;\">");
		sbMsg1Solicitud.append("Estimado/a, ");
		sbMsg1Solicitud.append("<b>");
		sbMsg1Solicitud.append(nombre);
		sbMsg1Solicitud.append("</b>");
		sbMsg1Solicitud.append("<br><br>");
		sbMsg1Solicitud.append(
				"Hemos recibido una solicitud para restablecer su cuenta de ConcesionarioUQ. Si no ha solicitado esta acción, por favor ignore este mensaje.<br>");
		sbMsg1Solicitud.append(
				"Para restablecer su cuenta, por favor utilice el siguiente código de recuperación de 6 letras: ");
		sbMsg1Solicitud.append("</p>");
		return sbMsg1Solicitud;
	}

	private static StringBuilder generarMensajeCodigo(String codigo) {
		StringBuilder sbMsg2TablaCodigo = new StringBuilder();
		sbMsg2TablaCodigo.append("<center>");
		sbMsg2TablaCodigo.append("	<table>");
		sbMsg2TablaCodigo.append("		<tr>");
		anadirCodigoHtmlStringBuilder(sbMsg2TablaCodigo, codigo);
		sbMsg2TablaCodigo.append("		</tr>");
		sbMsg2TablaCodigo.append("	</table>");
		sbMsg2TablaCodigo.append("</center>");
		return sbMsg2TablaCodigo;
	}

	private static void anadirCodigoHtmlStringBuilder(StringBuilder stringBuilder, String codigo) {
		for (int i = 0; i < codigo.length(); i++) {
			char caracter = codigo.charAt(i);
			stringBuilder.append("<td style=\"width: 30px; height: 30px; border-style: solid; border-width: 1px	;\">");
			stringBuilder.append("  <p style=\"text-align: center;\">");
			stringBuilder.append(Character.toString(caracter));
			stringBuilder.append("  </p>");
			stringBuilder.append("</td>");
		}
	}

	private static StringBuilder generarMensaje2Cuerpo() {
		StringBuilder sbMsg3Instrucciones = new StringBuilder();
		sbMsg3Instrucciones.append("<p style=\"font-family:'Open Sans',sans-serif;font-size:15px;\">");
		sbMsg3Instrucciones.append(
				"Ingrese este código en la aplicación del concesionario y siga las instrucciones para restablecer su contraseña.");
		sbMsg3Instrucciones.append("</p>");
		return sbMsg3Instrucciones;
	}
}
