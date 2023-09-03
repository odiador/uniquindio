package co.edu.uniquindio.concesionariouq.model;

import java.time.LocalDateTime;
import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.TransaccionNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.TransaccionYaExisteException;

public interface GestionableTransaccion {

	public void agregarTransaccion(Transaccion transaccion)
			throws TransaccionYaExisteException, AtributosFaltantesException, NullException;

	public void eliminarTransaccion(LocalDateTime momento)
			throws TransaccionNoExisteException, AtributosFaltantesException, NullException;

	public Transaccion buscarTransaccion(LocalDateTime momento);

	public default boolean validarTransaccion(LocalDateTime momento) {
		return buscarTransaccion(momento) != null;
	}

	public List<Transaccion> listarTransacciones();
}
