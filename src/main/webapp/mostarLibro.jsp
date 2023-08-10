<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.util.List"
		 import = "models.LibroModel" %>
		 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Lista de Libreos</h1>

<%
List<LibroModel> listaLibros = (List)request.getSession().getAttribute("listarLibro");

for (LibroModel lib : listaLibros ){

%>
<h3>Título: <%= lib.getTitulo() %> </h3>
<h3>ISBN: <%= lib.getISBN() %> </h3>
<h3>Anio: <%= lib.getAnio() %> </h3>
<h3>Ejemplares: <%= lib.getEjemplares() %> </h3>
<h3>Alta: <%= lib.getAlta() %> </h3>
<br>

<form action="SvLibro" method="POST">
<input type="hidden" name="action" value="eliminar"><input
 type="hidden" name="id_libro" value=<%= lib.getId() %>>
<button type ="submit">Eliminar</button>
</form>

<form action="SvLibro" method="GET">
<input type="hidden" name="action" value="actualizar"><input
 type="hidden" name="id_libro" value=<%= lib.getId() %>>
<button type ="submit">Editar</button>
</form>

<% } %>
</body>
</html>