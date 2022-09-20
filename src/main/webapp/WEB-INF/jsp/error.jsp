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
	<div class="container" style="display: flex; flex-direction: column; align-items: center; justify-content: center;">
		<div class="alert alert-danger mb-4 mt-4" role="alert" style="width: 600px; height: 300px; font-size: 50px; font-weigth: bold; display: flex; align-items: center; justify-content: center;">
			<span>ERRO</span>
		</div>
		<button type="button" class="btn btn-dark mb-3" onclick="window.history.back()">Voltar</button>
	</div>
</body>
</html>