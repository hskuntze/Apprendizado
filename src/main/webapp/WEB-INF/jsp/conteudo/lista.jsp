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
		<h4 class="mt-3">Classe: Conteúdo</h4>
		<a href="/conteudos/cadastro"><button class="btn btn-outline-secondary my-3">Cadastrar</button></a>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Título</th>
					<th scope="col">Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Java</td>
					<td>Conteúdos sobre a ferramenta Java, JavaFX, POO e muito
						mais.</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Spring</td>
					<td>Conteúdos sobre a ecossistema Spring, o mais poderoso e
						maduro framework para Java no mercado.</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Javascript</td>
					<td>Conteúdos sobre a ferramenta Javascript.</td>
				</tr>
				<tr>
					<td>4</td>
					<td>React</td>
					<td>Conteúdos sobre o framework ReactJS.</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>