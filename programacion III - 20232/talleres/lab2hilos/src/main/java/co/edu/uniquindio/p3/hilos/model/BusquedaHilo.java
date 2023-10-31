package co.edu.uniquindio.p3.hilos.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class BusquedaHilo extends Thread {

	private final ArrayList<String> clientes;
	private final String cadenaBuscada;
	private final int posInicial;
	private final int posFinal;

	@Getter
	@Setter
	private boolean vivo;
	private Observador observador;

	public BusquedaHilo(ArrayList<String> clientes, String cadenaBuscada, int posInicial, int posFinal) {
		this.clientes = clientes;
		this.cadenaBuscada = cadenaBuscada;
		this.posInicial = posInicial;
		this.posFinal = posFinal;
		this.vivo = true;
	}

	@Override
	public void run() {
		boolean encontrado = false;
		long tiempoInicial = System.currentTimeMillis();
		int iteraciones = 0;
		for (int i = posInicial; i < posFinal && vivo; i++) {
			if (clientes.get(i).equals(cadenaBuscada)) {
				encontrado = true;
				// Se notifica al observador que ya encontró el valor buscado
				observador.notificar();
				vivo = false;
			}
			iteraciones++;
		}

		long tiempoFinal = System.currentTimeMillis();
		String mensaje = encontrado ? "lo encontré" : "no lo encontré";

		System.out.println("Tiempo total gastado en la búsqueda: " + (tiempoFinal - tiempoInicial) / 1000
				+ " segundos pero " + mensaje + ". Hice " + iteraciones + " iteraciones");
	}

	public void setObservador(Observador observador) {
		this.observador = observador;

	}
}
