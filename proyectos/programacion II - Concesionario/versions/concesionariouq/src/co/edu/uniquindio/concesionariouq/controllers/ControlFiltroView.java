package co.edu.uniquindio.concesionariouq.controllers;

import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosEstado;
import static co.edu.uniquindio.concesionariouq.controllers.ControlFiltros.filtrarListaVehiculosTipo;
import static co.edu.uniquindio.concesionariouq.util.ProjectUtility.mostrarAdvertencia;
import static co.edu.uniquindio.concesionariouq.util.ProjectUtility.mostrarConfirmacion;
import static co.edu.uniquindio.concesionariouq.view.ver.PanelVerFiltros.filtros;
import static co.edu.uniquindio.concesionariouq.view.ver.PanelVerVehiculos.listaVehiculos;

import co.edu.uniquindio.concesionariouq.exceptions.FiltroException;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.TipoFiltro;
import co.edu.uniquindio.concesionariouq.model.TipoVehiculo;
import co.edu.uniquindio.concesionariouq.util.Relacion;
import co.edu.uniquindio.concesionariouq.view.menu.TipoCombustible;
import co.edu.uniquindio.concesionariouq.view.ver.PanelVerVehiculos;

public class ControlFiltroView {

	public static void aplicarFiltros() {
		listaVehiculos = PanelVerVehiculos.listar();
		for (Relacion<TipoFiltro, String> filtro : filtros) {
			try {
				filtrar(filtro);
			} catch (FiltroException e) {
				e.printStackTrace();
			}
		}
		System.out.println(listaVehiculos);
		System.out.println(filtros);
	}

	public static void filtrar(Relacion<TipoFiltro, String> relacion) throws FiltroException {
		TipoFiltro tipo = relacion.getValor1();
		String cadena = relacion.getValor2();
		switch (tipo) {
		case COMBUSTIBLE:
			TipoCombustible tipoCombustible = TipoCombustible.getTipo(cadena);
			filtrarCombustible(tipoCombustible);
			break;
		case ESTADO_VEHICULO:
			EstadoVehiculo estado = EstadoVehiculo.obtenerEstadoTexto(cadena);
			listaVehiculos = filtrarListaVehiculosEstado(listaVehiculos, estado);
			break;
		case TIPO_VEHICULO:
			TipoVehiculo tipoVehiculo = TipoVehiculo.obtenerValorTipo(cadena);
			listaVehiculos = filtrarListaVehiculosTipo(listaVehiculos, tipoVehiculo);
			break;
		}
	}

	private static void filtrarCombustible(TipoCombustible tipoCombustible) throws FiltroException {
		switch (tipoCombustible) {
		case DIESEL:
			listaVehiculos = ControlFiltros.filtrarListaVehiculosDiesel(listaVehiculos);
			break;
		case ELECTRICO:
			listaVehiculos = ControlFiltros.filtrarListaVehiculosElectricos(listaVehiculos);
			break;
		case GASOLINA:
			listaVehiculos = ControlFiltros.filtrarListaVehiculosGasolina(listaVehiculos);
			break;
		case HIBRIDO:
			listaVehiculos = ControlFiltros.filtrarListaVehiculosHibridos(listaVehiculos);
			break;
		}
	}

	private static boolean validarFiltro(Relacion<TipoFiltro, String> filtro) {
		return buscarFiltro(filtro) != null;
	}

	private static Relacion<TipoFiltro, String> buscarFiltro(Relacion<TipoFiltro, String> filtro) {
		return filtros.stream().filter(cadaFiltro -> cadaFiltro.equals(filtro)).findFirst()
				.orElse(null);
	}

	public static void agregarFiltro(TipoFiltro tipoFiltro, String text) {
		try {
			agregarFiltroThrows(tipoFiltro, text);
			mostrarConfirmacion("El filtro ha sido agregado con éxito, recuerda darle a guardar para aplicarlos");
		} catch (FiltroException e) {
			mostrarAdvertencia(e.getMessage());
		}
		aplicarFiltros();
	}

	private static void agregarFiltroThrows(TipoFiltro tipoFiltro, String text) throws FiltroException {
		Relacion<TipoFiltro, String> filtroAgregar = new Relacion<TipoFiltro, String>(tipoFiltro, text);
		if (validarFiltro(filtroAgregar))
			throw new FiltroException("El filtro ya existe");
		filtros.add(filtroAgregar);
	}
}
