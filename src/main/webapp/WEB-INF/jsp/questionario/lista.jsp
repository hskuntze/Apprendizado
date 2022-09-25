<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question�rio</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<div class="container mt-3">
		<h4 class="mt-3">Question�rios</h4>
		<a href="/questionarios/cadastro"><button class="btn btn-outline-secondary my-3">Cadastrar</button></a>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">T�tulo</th>
					<th scope="col">Descri��o</th>
					<th scope="col">Quest�es</th>
					<th scope="col">Respostas</th>
					<th scope="col">Tempo Limite</th>
					<th scope="col">#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${listagemQuestionarios}">
					<tr>
						<td>${b.id}</td>
						<td>${b.titulo}</td>
						<td>${b.descricao}</td>
						<td>
							<ul class="list-group">
								<li class="list-group-item">${b.questoes}</li>
							</ul>
						</td>
						<td>
							<ul class="list-group">
								<li class="list-group-item">${b.respostas}</li>
							</ul>
						</td>
						<td>${b.tempoLimite}</td>
						<td><a href="/questionarios/${b.id}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>