package fp.biblioteca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import fp.utiles.Checkers;

public class BibliotecaImpl {
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String localidad;
	private String telefono;
	private String email;
	private List<Libro> libros;
	
	public BibliotecaImpl(String nombre, String localidad) {
		this.nombre=nombre;
		this.localidad=localidad;
		this.direccion=null;
		this.codigoPostal=null;
		this.telefono=null;
		this.email=null;
		this.libros=new ArrayList<Libro>();
		
		Checkers.check("Nombre de biblioteca no válido", nombre != null);
		Checkers.check("Nombre de localidad no válido", localidad != null);
		Checkers.check("Email no válido", email == null || (email.contains("@") && email.contains(".")));
		
		// o R1: El nombre y la localidad no pueden ser null.
		// o R2: El email o es null o debe contener los caracteres '@' y '.'
	}
	//getters
    
	/**
	 * @return the nombre
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * @return the direccion
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	/**
	 * @return the codigoPostal
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @return the localidad
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the telefono
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the email
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @return the libros
	 */
	public List<Libro> getLibros() {
		return libros;
	}
	
	//setters
	
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	//otras operaciones
	
	public String toString() {
		return nombre + "(" + localidad + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BibliotecaImpl))
			return false;
		BibliotecaImpl other = (BibliotecaImpl) obj;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public void agregarLibros(Collection<Libro> l) {
		this.libros= (list<Libro>) l;
	}
	

	public SortedMap<Integer, Integer> contarLibrosPorAnyo(){
		SortedMap<Integer,Integer> res= new TreeMap<Integer,Integer>();
		for(Libro l:libros) {
			int clave = l.getFechaAdquisicion().getYear();
//			if(res.containsKey(clave)) {
//				res.put(clave,res.get(clave)+1);	
//			}else {
//				res.put(clave,1);
//			}
			if (!res.containsKey(clave)) {
				res.put(clave, 1);
				
			}else {
				res.put(clave, res.get(clave)+1);	
			}
								
		}return res;

		
	}
	public Map<String, Integer> contarLibrosPorAutor(){
		SortedMap<String,Integer> res= new TreeMap<String,Integer>();
		for(Libro l:libros) {
			String clave = l.getSAutor();
//			if(res.containsKey(clave)) {
//				res.put(clave,res.get(clave)+1);	
//			}else {
//				res.put(clave,1);
//			}
			if (!res.containsKey(clave)) {
				res.put(clave, 1);
				
			}else {
				res.put(clave, res.get(clave)+1);	
			}
								
		}return res;
	}
	public SortedMap<Integer, Set<String>> librosPorAutor(){
		Map<String,Integer> origen= contarLibrosPorAutor();
		 SortedMap<Integer, Set<String>> res = new TreeMap<Integer,Set<String>>();
		 for(Map.Entry<String,Integer> pareja:origen.entrySet()) {
			 Integer clave = pareja.getValue();
				if (!res.containsKey(clave)) {
					Set<String> autores = new HashSet<String>();
					autores.add(pareja.getKey());
					
				}
		 }
		return res;

       	
	}
	//public Integer getNumBestSellers() {
		//esquema contador
		//Integer cont = 0;
		//for(Libro l: this.libros) {
			//if(l.esBestSeller)
		//}return null;
		
	//}
	
	public Integer getTotalPaginas(String autor) {
		Integer totalPaginas = 0;
		for(Libro l:libros) {
			if(l.getSAutor().equals(autor)) {
				totalPaginas += l.getNumeroPaginas();
				//total
			}
		}return totalPaginas;
		
	}
	
	public Set<String> getAutores(){
		Set<String> res= new HashSet<String>();
		for(Libro l:libros) {
			res.add(l.getSAutor());
		}return null;
	}

}
