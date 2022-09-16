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
		<form action="/tarefas/incluir" method="post" style="display: flex; flex-direction: column;">
			<c:import url="/WEB-INF/jsp/conteudo/cadastro.jsp"></c:import>
			<div class="mb-3 mt-3">
				<label for="linkTarefa">Link da tarefa:</label> 
				<input type="text" class="form-control" placeholder="Link da tarefa" name="linkTarefa">
			</div>
			<div>
				<label>Já foi entregue?</label>
				<label class="radio-inline">
			    	<input type="radio" name="entregue" value="true"> Sim
			    </label>
			    <label class="radio-inline">
			    	<input type="radio" name="entregue" value="false"> Não
			    </label>
			</div>
			<span class="text-muted fw-light fst-italic" style="font-size: 13px">OBS.: Uma tarefa tem 2 semanas para ser entregue a partir do momento do cadastro.</span>
			<button type="submit" class="btn btn-primary mt-2" style="width: 100px">Submit</button>
		</form>
	</div>
</body>
</html>