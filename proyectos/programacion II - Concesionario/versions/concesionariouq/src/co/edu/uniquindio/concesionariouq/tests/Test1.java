package co.edu.uniquindio.concesionariouq.tests;

import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosGasolina;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosPlacaEmpezando;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosTipo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.edu.uniquindio.concesionariouq.exceptions.ConcesionarioException;
import co.edu.uniquindio.concesionariouq.exceptions.FiltroException;
import co.edu.uniquindio.concesionariouq.model.Concesionario;
import co.edu.uniquindio.concesionariouq.model.Diesel;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.Gasolina;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.model.TipoVehiculo;
import co.edu.uniquindio.concesionariouq.model.Vehiculo;

public class Test1 {
	Concesionario concesionario = new Concesionario("Nombre", "id");

	@Before
	public void test() throws ConcesionarioException {
		concesionario.agregarMoto("AAAA", "mazda", "2020", 200d, 200d, new Gasolina(), EstadoVehiculo.NUEVO,
				TipoCambio.AUTOMATICO);
		concesionario.agregarDeportivo("XG", "mazda", "2020", 1000d, 100d, new Gasolina(), EstadoVehiculo.NUEVO,
				TipoCambio.MANUAL, 5, 2, 3, 40, 4);
		concesionario.agregarMoto("ASAAS", "maxda", "2020", 200d, 200d, new Gasolina(), EstadoVehiculo.NUEVO,
				TipoCambio.AUTOMATICO);
		concesionario.agregarMoto("AAAV", "mazda", "2020", 200d, 200d, new Gasolina(), EstadoVehiculo.NUEVO,
				TipoCambio.AUTOMATICO);
		concesionario.agregarMoto("AAAZ", "mazda", "2020", 200d, 200d, new Diesel(), EstadoVehiculo.NUEVO,
				TipoCambio.AUTOMATICO);
		System.out.println(concesionario.listarVehiculos());
	}

	@Test
	public void testFiltros() throws ConcesionarioException {
		List<? extends Vehiculo> lista = concesionario.listarVehiculos();
		lista.stream().map(v -> v.getTipoVehiculo().getTipo() + " [" + v.getPlaca() + "]").forEach(System.out::println);
		try {
			lista = filtrarListaVehiculosTipo(lista, TipoVehiculo.MOTO);
			lista = filtrarListaVehiculosGasolina(lista);
			lista = filtrarListaVehiculosPlacaEmpezando(lista, "AAA");
		} catch (FiltroException e) {
			return;
		}
		System.err.println("----------------");
		lista.stream().map(v -> v.getTipoVehiculo().getTipo() + " [" + v.getPlaca() + "]").forEach(System.out::println);
	}

}
