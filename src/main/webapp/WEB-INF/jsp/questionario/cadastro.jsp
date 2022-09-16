<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<div class="container mt-3">
		<form action="/questionarios/incluir" method="post" style="display: flex; flex-direction: column;">
			<c:import url="/WEB-INF/jsp/conteudo/cadastro.jsp"></c:import>
			<div class="mb-3 mt-3">
				<label for="tempoLimite">Tempo limite: <span class="text-muted fs-6 fw-light">(em minutos)</span></label> 
				<input type="text" class="form-control" placeholder="Tempo limite do questionário" name="tempoLimite">
			</div>
			<button type="submit" class="btn btn-primary mt-2" style="width: 100px">Submit</button>
		</form>
	</div>
</body>
</html>