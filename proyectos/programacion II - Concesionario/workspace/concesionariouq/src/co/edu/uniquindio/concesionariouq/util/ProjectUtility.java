package co.edu.uniquindio.concesionariouq.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Transport;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.uniquindio.concesionariouq.model.Vehiculo;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProjectUtility {

	public static void mostrarAdvertencia(String msg) {
		new Alert(AlertType.WARNING, msg).show();
	}

	public static void mostrarConfirmacion(String msg) {
		new Alert(AlertType.CONFIRMATION, msg).show();
	}

	public static void enviarCorreoRecuperacion(final String toMail, final String nombre, final String codigo)
			throws MessagingException, IOException {
		Properties prop = new Properties();
		MailUtility.agregarPropiedadesCorreo(prop);
		CorreoRecuperacion mensajeCorreo = new CorreoRecuperacion(
				MailUtility.generarSesion(MailUtility.MAILFROM, MailUtility.PASSWORD, prop), MailUtility.MAILFROM,
				toMail, nombre, codigo);
		Transport.send(mensajeCorreo);
	}

	public static void enviarCorreoReporte(final String toMail, final String nombre, final String reporte,
			final String info, final File archivo) throws MessagingException, IOException {
		Properties prop = new Properties();
		MailUtility.agregarPropiedadesCorreo(prop);

		CorreoReporte mensajeCorreo = new CorreoReporte(
				MailUtility.generarSesion(MailUtility.MAILFROM, MailUtility.PASSWORD, prop), MailUtility.MAILFROM,
				toMail, nombre, reporte, info, archivo);
		Transport.send(mensajeCorreo);
	}

	public static String crearCodigoRandomAlfaNumerico(int tam) {
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tam; i++) {
			final int num = secureRandom.nextInt('Z' - 'A' + 1 + 10);
			builder.append(num < 10 ? num : String.valueOf((char) ('A' + num - 10)));
		}
		return builder.toString();
	}

	public static void enviarReporteConPdf(List<Vehiculo> listaVehiculos, String reporte, String toMail, String nombre)
			throws MessagingException, IOException {
		ProjectUtility.generarPdf(reporte, listaVehiculos);
		File file = new File(reporte + ".pdf");
		enviarCorreoReporte(toMail, nombre, reporte, " todos los vehiculos", file);
		file.delete();
	}

	public static void generarPdf(String titulo, List<Vehiculo> listaVehiculos) {
		try {
			Document document = new Document(PageSize.A4.rotate(), 0, 0, 0, 0);
			PdfWriter.getInstance(document, new FileOutputStream(titulo + ".pdf"));
			document.open();
			document.addAuthor("Concesionario UQ");
	
			PdfUtility.agregarHeaderDocumento(document, titulo);
			PdfUtility.agregarTablaVehiculosDocumento(document, listaVehiculos);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
