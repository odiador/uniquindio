package co.edu.uniquindio.biblioteca.model;

public class Libro {

	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private Tipo tipo;

	/**
	 * 
	 * @param titulo
	 * @param autor
	 * @param editorial
	 * @param isbn
	 */
	public Libro(String titulo, String autor, String editorial, String isbn, Tipo tipo) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.tipo = tipo;
	}

	/**
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @return
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * 
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * 
	 * @return
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * 
	 * @param editorial
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * 
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 
	 * @param titulo
	 * @return
	 */
	public boolean cumpleTitulo(String titulo) {
		return getTitulo().equals(titulo);
	}

	/**
	 * 
	 * @param autor
	 * @return
	 */
	public boolean cumpleAutor(String autor) {
		return getAutor().equals(autor);
	}

	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public boolean cumpleIsbn(String isbn) {
		return getIsbn().equals(isbn);
	}

	/**
	 * 
	 * @return
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn=" + isbn
				+ ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}
