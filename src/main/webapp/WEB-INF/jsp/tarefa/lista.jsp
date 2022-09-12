<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarefa</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<h4 class="mt-3">Classe: Tarefa</h4>
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Título</th>
				<th scope="col">Descrição</th>
				<th scope="col">Entregue</th>
				<th scope="col">Data Final</th>
				<th scope="col">Link da Tarefa</th>
				<th scope="col">#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${listagemTarefas}">
				<tr>
					<td>${b.id}</td>
					<td>${b.titulo}</td>
					<td>${b.descricao}</td>
					<td>${b.entregue}</td>
					<td>${b.dataFinal}</td>
					<td>${b.linkTarefa}</td>
					<td><a href="/tarefas/${b.id}/excluir">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>