<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"
		 import = "models.LibroModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda de libro por ISBN</title>
</head>
<body>
<%
List<LibroModel> listaLibros = (List)request.getSession().getAttribute("listarLibroIsbn");

for (LibroModel lib : listaLibros ){

%>
<h3>Título: <%= lib.getTitulo() %> </h3>
<h3>ISBN: <%= lib.getISBN() %> </h3>
<h3>Anio: <%= lib.getAnio() %> </h3>
<h3>Ejemplares: <%= lib.getEjemplares() %> </h3>
<h3>Alta: <%= lib.getAlta() %> </h3>
<br>
</form>

<% } %>

</body>
</html>