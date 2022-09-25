<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Conte�do</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<div class="container mt-3">
		<h4 class="mt-3">Conte�dos</h4>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">T�tulo</th>
					<th scope="col">Descri��o</th>
					<th scope="col">#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${listagemConteudos}">
					<tr>
						<td>${c.id}</td>
						<td>${c.titulo}</td>
						<td>${c.descricao}</td>
						<td><a href="/conteudos/${c.id}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>