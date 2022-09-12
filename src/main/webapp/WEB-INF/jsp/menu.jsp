<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Menu</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link"
						href="/usuarios/lista">Usuários</a></li>
					<li class="nav-item"><a class="nav-link" href="/cursos/lista">Cursos</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/responsaveis/lista">Responsáveis</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/conteudos/lista">Conteudos</a></li>
					<li class="nav-item"><a class="nav-link" href="/tarefas/lista">Tarefas</a></li>
					<li class="nav-item"><a class="nav-link" href="/videos/lista">Vídeos</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/questionarios/lista">Questionário</a></li>
				</c:if>
			</ul>
			<ul class="navbar-nav">
				<c:if test="${empty user}">
					<li class="nav-item"><a class="nav-link" href="/usuarios/cadastro">Cadastrar</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/login">Login</a>
					</li>
				</c:if>
				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link" href="/logout">Logout,
							${user}</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>