package co.edu.uniquindio.concesionariouq.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProjectUtility {

	public static final String MAILFROM = getMailName();
	private static final String PASSWORD = getPassword();

	private static StringBuilder desencriptar(String msg) {
		StringBuilder stringBuilder = new StringBuilder();
		msg.codePoints().map(num -> num - 1).mapToObj(num -> Character.toString((char) num))
				.forEach(stringBuilder::append);
		return stringBuilder;
	}

	private static String getMailInfo() {
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

	private final static String getPassword() {
		return desencriptar(getMailInfo()).toString().split("-")[1];
	}

	private final static String getMailName() {
		return desencriptar(getMailInfo()).toString().split("-")[0];
	}

	public static void mostrarAdvertencia(String msg) {
		new Alert(AlertType.WARNING, msg).show();
	}

	public static void mostrarConfirmacion(String msg) {
		new Alert(AlertType.CONFIRMATION, msg).show();
	}

	public static void enviarCorreoRecuperacion(final String toMail, final String nombre, final String codigo)
			throws MessagingException, IOException {
		Properties prop = new Properties();
		agregarPropiedadesCorreo(prop);
		CorreoRecuperacion mensajeCorreo = new CorreoRecuperacion(generarSesion(MAILFROM, PASSWORD, prop), MAILFROM,
				toMail, nombre, codigo);
		Transport.send(mensajeCorreo);
	}

	private static Session generarSesion(String mailFrom, String mailPassword, Properties prop) {
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, mailPassword);
			}
		});
		return session;
	}

	private static void agregarPropiedadesCorreo(Properties prop) {
		prop.put("mail.smtp.auth", true); //$NON-NLS-1$
		prop.put("mail.smtp.starttls.enable", true); //$NON-NLS-1$
		prop.put("mail.smtp.port", "587"); //$NON-NLS-1$ //$NON-NLS-2$
		prop.put("mail.smtp.host", "smtp.gmail.com"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
