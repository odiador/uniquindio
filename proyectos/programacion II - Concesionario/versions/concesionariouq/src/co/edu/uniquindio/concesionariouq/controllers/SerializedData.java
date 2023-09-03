package co.edu.uniquindio.concesionariouq.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.concesionariouq.model.Concesionario;

public class SerializedData {

	private Concesionario concesionario;
	private static final String RUTA = "src/co/edu/uniquindio/concesionariouq/controllers/info.dat";

	public SerializedData() {
		try {
			leerConcesionario();
		} catch (Exception e) {
			concesionario = new Concesionario("Carro UQ", "omnisciente");
			try {
				escribirConcesionario();
			} catch (Exception e1) {
			}
		}

	}

	public void leerConcesionario() throws Exception {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(RUTA));
		setConcesionario((Concesionario) stream.readObject());
		stream.close();
	}

	public void escribirConcesionario() throws Exception {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(RUTA));
		stream.writeObject(concesionario);
		stream.close();
	}

	public Concesionario getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}
}
