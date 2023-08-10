<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Agregar Libro</h1>

<form action="SvLibro" method = "POST">
<input type="hidden" name = "action" value = "crear">
<label>Título: <input type = "text" name ="titulo"></label>
<label>ISBN  <input type = "text" name ="isbn"></label>
<label>Anio  <input type = "text" name ="anio"></label>
<label>Ejemplares  <input type = "text" name ="ejemplares"></label>
<label>Alta  <input type = "text" name ="alta"></label>

<button type="submit" >Enviar</button>
</form>
<br>
<br>
<br>

<form action="SvLibro" method = "GET">
<h1>Hacer Click para ver los libros</h1>
<button type="submit" >Mostrar Libros</button>
</form>

<form action="SvLibro" method ="Get">
<input type="hidden" name ="action" value= "buscarIsbn">
<h1>Buscar Libro por ISBN</h1>
<label>Buscar por ISBN  <input type = "text" name ="isbn2"></label>
<button type="submit">Buscar</button>
</form>


</body>
</html>