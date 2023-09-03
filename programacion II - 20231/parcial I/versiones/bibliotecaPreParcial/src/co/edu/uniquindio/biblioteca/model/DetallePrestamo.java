package co.edu.uniquindio.biblioteca.model;

public class DetallePrestamo {

	private String codigo;
	private double subTotal;
	private int cantidad;
	private Libro libro;
	public DetallePrestamo(String codigo, double subTotal, int cantidad, Libro libro) {
		super();
		this.codigo = codigo;
		this.subTotal = subTotal;
		this.cantidad = cantidad;
		this.libro = libro;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	@Override
	public String toString() {
		return "DetallePrestamo [codigo=" + codigo + ", subTotal=" + subTotal + ", cantidad=" + cantidad + ", libro="
				+ libro + "]";
	}
	public boolean verificarCantidad() {
		
		if(cantidad > 20){
			return true;
		}
		return false;
	}
	public boolean cumpleIsbn(String isbn) {
		return libro.cumpleIsbn(isbn);
	}
	
	public boolean cumpleIsbn(String isbn,String codigo) {
		return libro.cumpleIsbn(isbn);
	}
	public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior) {
		
		boolean cumpleNombre = false;
		boolean cumpleCantidad = false;
		
		cumpleCantidad = verificarRango(limiteInferior,limiteSuperior);
		cumpleNombre = verificarNombre(titulo);
		
		if(cumpleCantidad && cumpleNombre){
			return true;
		}
		return false;
	}
	
	private boolean verificarNombre(String titulo) {
		return getLibro().getTitulo().equals(titulo);
	}
	
	private boolean verificarRango(int limiteInferior, int limiteSuperior) {
		if(cantidad >= limiteInferior && cantidad < limiteSuperior) return true;
		return false;
	}
	public boolean cumpleTipo(Tipo tipo) {
		
		return getLibro().getTipo() == tipo;
	}
	
	
	
}
