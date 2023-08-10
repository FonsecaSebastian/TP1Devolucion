<%@ page import = "models.LibroModel" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Libro</title>
</head>
<body>
<h1>Modificar Libro</h1>
<% LibroModel lib = (LibroModel) request.getSession().getAttribute("libro"); %>

<form action="SvLibro" method="POST">

<input type="hidden" name="action" value = "actualizar" >
<input type="hidden" name= "id_libro" value=<%= lib.getId() %>>

<label>Titulo:<input
type="text"
name="titulo"
value=<%= lib.getTitulo()%>>
</label>

<label>ISBN:<input
type="text"
name="isbn"
value=<%= lib.getISBN() %>>
</label>

<label>Anio:<input
type="text"
name="anio"
value=<%= lib.getAnio() %>>
</label>

<label>Ejemplares:<input
type="text"
name="ejemplar"
value=<%= lib.getEjemplares() %>>
</label>

<label>Alta:<input
type="text"
name="alta"
value=<%= lib.getAlta() %>>
</label>
<button type="submit">Guardar</button>

</form>

</body>
</html>