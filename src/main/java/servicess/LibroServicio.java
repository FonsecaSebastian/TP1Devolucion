package servicess;

import repositories.LibroDAO;

import java.util.List;

import models.LibroModel;

public class LibroServicio {
	
LibroDAO libroDao;

public LibroServicio() {
	super();
	libroDao = new LibroDAO();
}

public void crearLibro(String isbn, String anio, String titulo, String ejemplar, String alta ) {
	LibroModel libroModel = new LibroModel();
	
	Integer castAnio = Integer.valueOf(anio);
	Integer castEjemplar = Integer.valueOf(ejemplar);
	Integer castAlta = Integer.valueOf(alta);
	Long castIsbn = Long.valueOf(isbn);
	
	libroModel.setAlta(castAlta);
	libroModel.setAnio(castAnio);
	libroModel.setEjemplares(castEjemplar);
	libroModel.setISBN(castIsbn); 
	libroModel.setTitulo(titulo);
	
	libroDao.GuardarLibro(libroModel);
}

public List<LibroModel> mostarLibro () {
	System.out.println("Llamo al moetodo mostar Libro"); // Despues sacar
	
	List<LibroModel> listaLibro = libroDao.obtenerLibros();
	return listaLibro;
	
}

public void borrarLibro(Integer id) {
	System.out.println("Llamo al moetodo borrar Libro"); // Despues sacar
	libroDao.eliminarLibro(id);
	
}

public void editarLibro (LibroModel libro) {
	System.out.println("Llamo al moetodo editar"); // Despues sacar
	libroDao.actualizarLibro(libro);
}

public LibroModel obtenerLibro (Integer id) {
	System.out.println("Llamo al moetodo obtenerLibro"); // Despues sacar
	LibroModel libro = libroDao.buscarLibroPorId(id);
	System.out.println("Llamo al moetodo obtenerLibro" + libro.toString() ); // Despues sacar
	return libro; 
	
	
}

public List<LibroModel> buscarLibroISBN (Integer id) {
	System.out.println("Llamo al moetodo mostar Libro"); // Despues sacar
	System.out.println("Valor del Integer" + id.toString()); // Despues sacar
	List<LibroModel> listaLibro = libroDao.buscarLibroPorISBN(id);
	System.out.println("Paso el metodo buscarLibroISBN"); // Despues sacar
	System.out.println("Valor del listarLibro"+listaLibro.toString()); // Despues sacar
	
	return listaLibro;
	
}



	
}
