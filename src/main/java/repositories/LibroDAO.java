package repositories;
import java.util.ArrayList;
import java.util.List;

import models.LibroModel;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import connections.Conexion;

public class LibroDAO {
	EntityManager entity;
	
	public void GuardarLibro(LibroModel libro){
		entity = Conexion.getEntityManager();
		try{
			entity.getTransaction().begin();
			entity.persist(libro);
			entity.getTransaction().commit();
		}finally {
			if (entity != null){
				entity.close();
			}
				
			}
		}	
		
	public void eliminarLibro(Integer id){
		
		LibroModel libroModel = buscarLibroPorId(id);	
		
		try{
			entity.getTransaction().begin();
			entity.remove(libroModel);
			entity.getTransaction().commit();
		}finally {
			if (entity != null){
				entity.close();
			}
				
			}
		}
	
	public void actualizarLibro (LibroModel libro ) {
		entity = Conexion.getEntityManager();
		try {
			entity.getTransaction().begin();
			entity.merge(libro);
			entity.getTransaction().commit();
		}finally {
			if (entity != null) {
				entity.close(); 
			}
			
			}
		}		
	
	public LibroModel buscarLibroPorId (Integer id) {
		entity = Conexion.getEntityManager();
		
		LibroModel libro = new LibroModel();
		libro = entity.find (LibroModel.class, id);
		return libro;		
		
	}
	
	public List <LibroModel> buscarLibroPorISBN (Integer id) {
		entity = Conexion.getEntityManager();
		try {
			List<LibroModel> libroModel = new ArrayList();
			Query sql =  entity.createQuery ("SELECT a FROM LibroModel a WHERE ISBN = id "); 
			return libroModel = sql.getResultList();
		}finally {
			if (entity != null) {
				entity.close();
			}
		}
		
	}
	
	public List <LibroModel> obtenerLibros(){
		entity = Conexion.getEntityManager();
		try {
			List<LibroModel> libroModel = new ArrayList();
			Query sql =  entity.createQuery ("SELECT a FROM LibroModel a"); 
			return libroModel = sql.getResultList();
		}finally {
			if (entity != null) {
				entity.close();
			}
		}
	}

	public void cerrarConexion() {
		entity.close();
	}

	

}
