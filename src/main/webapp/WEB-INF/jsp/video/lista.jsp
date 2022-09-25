<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Vídeo</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<div class="container mt-3">
		<h4 class="mt-3">Vídeos</h4>
		<a href="/videos/cadastro"><button class="btn btn-outline-secondary my-3">Cadastrar</button></a>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Título</th>
					<th scope="col">Descrição</th>
					<th scope="col">URL do vídeo</th>
					<th scope="col">Finalizado</th>
					<th scope="col">Acessado em</th>
					<th scope="col">#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${listagemVideos}">
					<tr>
						<td>${b.id}</td>
						<td>${b.titulo}</td>
						<td>${b.descricao}</td>
						<td><a href="${b.videoUrl}">Link</a></td>
						<td>${b.finalizado}</td>
						<td>${b.acessadoEm}</td>
						<td><a href="/videos/${b.id}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>