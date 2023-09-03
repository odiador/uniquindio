package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;

import org.junit.experimental.theories.FromDataPoints;

public class Prestamo {

	private String fecha;
	private double total;
	private int tiempoEntrega;
	private String codio;
	private ArrayList<DetallePrestamo> listaDetallePrestamo;
	private Empleado empleadoPrestamo;
	
	
	
	
	public Prestamo(String fecha, double total, int tiempoEntrega, String codio) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.tiempoEntrega = tiempoEntrega;
		this.codio = codio;
		this.listaDetallePrestamo = new ArrayList<DetallePrestamo>();
	}
	
	
	
	public Empleado getEmpleadoPrestamo() {
		return empleadoPrestamo;
	}



	public void setEmpleadoPrestamo(Empleado empleadoPrestamo) {
		this.empleadoPrestamo = empleadoPrestamo;
	}



	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getTiempoEntrega() {
		return tiempoEntrega;
	}
	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}
	public String getCodio() {
		return codio;
	}
	public void setCodio(String codio) {
		this.codio = codio;
	}
	public ArrayList<DetallePrestamo> getListaDetallePrestamo() {
		return listaDetallePrestamo;
	}
	public void setListaDetallePrestamo(ArrayList<DetallePrestamo> listaDetallePrestamo) {
		this.listaDetallePrestamo = listaDetallePrestamo;
	}
	
	public boolean verificarTotalAutor(String autor, double valor) {
		boolean cumple = false;
		
		boolean totalVerificado = false;
		boolean autorVerificado = false;
		
//		totalVerificado = verificarTota(valor);
//		autorVerificado = verificarAutor(autor);
//		
//		if(totalVerificado == true && autorVerificado == true){
//			cumple = true;
//		}
//		
		return cumple;
	}



	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public boolean cumpleIsbn(String isbn) {
			
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if(detallePrestamo.cumpleIsbn(isbn)){
				return true;
			}
		}
		return false;
	}
	
	
public boolean cumpleIsbny(String isbn) {
		
		boolean cumple = false;
		for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
			if(detallePrestamo.getCantidad() > 10){
				return true;
			}
		}
		return cumple;
	}
	
public boolean cumpleIsbnx(String isbn) {
	
	boolean cumple = false;
	for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
		if(detallePrestamo.getCantidad() > 10){
			return true;
		}
	}
	return cumple;
}



public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia) {
	
	for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
		if(detallePrestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior)){
			return true;
		}
	}
	return false;
}



public int obtenerCantidadTipo(Tipo tipo) {
	int cantidad = 0;
	for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
		if(detallePrestamo.cumpleTipo(tipo)){
			cantidad += detallePrestamo.getCantidad();
		}
	}
	return cantidad;
}

	
	
}
