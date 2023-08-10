package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.LibroModel;
import servicess.LibroServicio;

@WebServlet (name = "SvLibro", urlPatterns = "/SvLibro")
public class SvLibro extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
	LibroServicio libroServicio;
	
    public SvLibro() {
        super();
        libroServicio = new LibroServicio();
    }  
     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");		
		if (action == null) {
			List <LibroModel> listaLibro =  libroServicio.mostarLibro(); 	
			
			HttpSession miSesion = request.getSession();
			miSesion.setAttribute("listarLibro", listaLibro);
			
			response.sendRedirect("mostarLibro.jsp");			
		} else if (action.equals("actualizar")) {			
			Integer id = Integer.parseInt(request.getParameter("id_libro"));			
			LibroModel libroModel = libroServicio.obtenerLibro(id);			
			HttpSession miSesion = request.getSession();
			miSesion.setAttribute("libro", libroModel);
			
			response.sendRedirect("editarLibro.jsp");
		}else if (action.equals("buscarIsbn")) {			
			Integer id = Integer.parseInt(request.getParameter("isbn2"));
			List <LibroModel> listaLibro =  libroServicio.buscarLibroISBN(id); 	
			
			HttpSession miSesion = request.getSession();
			miSesion.setAttribute("listarLibroIsbn", listaLibro);
			
			response.sendRedirect("buscarIsbn.jsp");
			
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
	System.out.println("Adentro del metodo doPost"); // Despues sacar
	if (action.equals("eliminar")) {
		
		System.out.println("Entro en el if de eliminar"); // Despues sacar
		
		Integer id = Integer.parseInt(request.getParameter("id_libro"));
		libroServicio.borrarLibro(id);
		response.sendRedirect("Index.jsp");
		
	}else if (action.equals("crear")) {
		LibroModel libro = new LibroModel ();
		String titulo = request.getParameter("titulo");
		String isbn = request.getParameter("isbn");
		String anio = request.getParameter("anio");
		String ejemplares = request.getParameter("ejemplares");
		String alta = request.getParameter("alta");
		
		libroServicio.crearLibro(isbn, anio, titulo, ejemplares, alta);
		response.sendRedirect("Index.jsp");
	}else if (action.equals("actualizar")) {
		Integer id = Integer.parseInt(request.getParameter("id_libro"));
		LibroModel libro = (LibroModel) request.getSession().getAttribute("libro");
		
		
		libro.setAlta(Integer.valueOf(request.getParameter("alta")));
		libro.setEjemplares(Integer.valueOf(request.getParameter("ejemplar")));
		libro.setAnio(Integer.valueOf(request.getParameter("anio")));
		libro.setISBN(Long.valueOf(request.getParameter("isbn")));
		libro.setTitulo(request.getParameter("titulo"));
		
		libroServicio.editarLibro(libro);			
		
		response.sendRedirect("Index.jsp");
		
	}
	System.out.println("Salio del else if"); // Despues sacar
		
	}

}
