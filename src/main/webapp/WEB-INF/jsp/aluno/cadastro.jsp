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
		<form action="/usuarios/incluir" method="post">
			<div class="mb-3 mt-3">
				<label for="email">Nome:</label> <input type="text"
					class="form-control" placeholder="Seu nome" name="nome">
			</div>
			<div class="mb-3 mt-3">
				<label for="email">Email:</label> <input type="email"
					class="form-control" placeholder="Seu e-mail" name="email">
			</div>
			<div class="mb-3">
				<label for="pwd">Senha:</label> <input type="password"
					class="form-control" placeholder="Sua senha" name="senha">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>