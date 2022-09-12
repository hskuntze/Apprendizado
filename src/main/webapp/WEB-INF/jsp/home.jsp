<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Apprendizado</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<div class="container">
		<h2>${projeto.nome}</h2>
		<p>${projeto.descricao}</p>
		<hr>
		<c:forEach var="c" items="${projeto.classes}">
			<h4 class="mt-3">Classe: ${c.nome}</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${c.atributos}">
						<tr>
							<td>${a.nome}</td>
							<td>${a.tipo}</td>
							<td>${a.descricao}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
	</div>
</body>
</html>