package co.edu.uniquindio.p3.hilos.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.p3.hilos.utils.ArchivoUtils;
import lombok.Setter;

public class Principal implements Observador {
	@Setter
	private ArrayList<String> clientes;
	private String valorBuscado;
	private BusquedaHilo[] hilos;

	public Principal(String valorBuscado) {
		this.clientes = new ArrayList<>();
		this.hilos = new BusquedaHilo[4];
		this.valorBuscado = valorBuscado;
		try {
			// Se leen los datos del archivo txt de clientes
			this.clientes = ArchivoUtils.leerArchivoBufferedReader("src/main/resources/clientes.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void realizarBusquedaSecuencial() {
		boolean encontrado = false;
		int i;
		long tiempoInicial = System.currentTimeMillis();

		for (i = 0; i < clientes.size() && !encontrado; i++) {
			if (clientes.get(i).contains(valorBuscado)) {
				encontrado = true;
			}
		}

		long tiempoFinal = System.currentTimeMillis();
		System.out.println("Tiempo total gastado en la búsqueda: " + (tiempoFinal - tiempoInicial) / 1000
				+ " segundos. Hice " + i + " iteraciones");
	}

	public void notificar() {
		// Cuando se invoca este método es porque uno de los hilos encontró el valor
		// buscado, entonces se detienen todos los hilos para que no sigan buscando
		for (BusquedaHilo h : hilos) {
			h.setVivo(false);
		}
	}

	public void realizarBusquedaHilos() {

		int size = clientes.size();
		int quarter = size / 4;
		hilos[0] = new BusquedaHilo(clientes, valorBuscado, 0, quarter);
		hilos[1] = new BusquedaHilo(clientes, valorBuscado, quarter, quarter * 2);
		hilos[2] = new BusquedaHilo(clientes, valorBuscado, quarter * 2, quarter * 3);
		hilos[3] = new BusquedaHilo(clientes, valorBuscado, quarter * 3, size);

		for (BusquedaHilo h : hilos) {
			// Se le asigna el observador actual a cada uno de los hilos creados
			h.setObservador(this);
			h.start();
		}

	}

}
