<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Conteúdo</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<div class="container mt-3">
		<h4>Usuários</h4>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Senha</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${listagem}">
					<tr>
						<td>${u.nome}</td>
						<td>${u.email}</td>
						<td>${u.senha}</td>
						<td><a href="/usuarios/${u.email}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>