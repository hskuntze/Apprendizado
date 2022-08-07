<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<div class="container">
			<h4 class="mt-3">Classe: Curso</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>id</td>
						<td>Long</td>
						<td>Chave primária; identificador do objeto.</td>
					</tr>
					<tr>
						<td>titulo</td>
						<td>String</td>
						<td>Nome/título do curso.</td>
					</tr>
					<tr>
						<td>inicio</td>
						<td>Instant</td>
						<td>Momento do ínicio do curso.</td>
					</tr>
					<tr>
						<td>fim</td>
						<td>Instant</td>
						<td>Momento do fim do curso.</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<h4 class="mt-3">Classe: Responsavel</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>id</td>
						<td>Long</td>
						<td>Chave primária; identificador do objeto.</td>
					</tr>
					<tr>
						<td>nome</td>
						<td>String</td>
						<td>Nome do responsável do curso.</td>
					</tr>
					<tr>
						<td>email</td>
						<td>String</td>
						<td>Email do responsável do curso.</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<h4 class="mt-3">Classe: Conteudo</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>id</td>
						<td>Long</td>
						<td>Chave primária; identificador do objeto.</td>
					</tr>
					<tr>
						<td>titulo</td>
						<td>String</td>
						<td>Nome/título do conteúdo.</td>
					</tr>
					<tr>
						<td>descricao</td>
						<td>String</td>
						<td>Breve descrição sobre o conteúdo.</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<h4 class="mt-3">Classe: Tarefa</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>entregue</td>
						<td>boolean</td>
						<td>Indica se a tarefa foi entregue.</td>
					</tr>
					<tr>
						<td>linkTarefa</td>
						<td>String</td>
						<td>Link do repositório onde a tarefa foi armazenada.</td>
					</tr>
					<tr>
						<td>dataFinal</td>
						<td>Instant</td>
						<td>Data final para a entrega da tarefa em questão.</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<h4 class="mt-3">Classe: Video</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>videoUrl</td>
						<td>String</td>
						<td>Link do vídeo para que a aplicação possa exibi-lo através da tag "embed"</td>
					</tr>
					<tr>
						<td>finalizado</td>
						<td>boolean</td>
						<td>Indica se o vídeo foi ou não finalizado.</td>
					</tr>
					<tr>
						<td>acessadoEm</td>
						<td>Instant</td>
						<td>Indica a data do último acesso do usuário ao vídeo em questão.</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<h4 class="mt-3">Classe: Questionario</h4>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>questoes</td>
						<td>Map<Integer,String></td>
						<td>Cada questão é mapeada por um número. Este número não representa o número da questão na prova.</td>
					</tr>
					<tr>
						<td>respostas</td>
						<td>Map<Integer,String></td>
						<td>Cada resposta é mapeada por um número que representa o número da questão na prova.</td>
					</tr>
					<tr>
						<td>tempoLimite</td>
						<td>Integer</td>
						<td>Tempo limite, em minutos, para finalizar o questionário a partir do momento em que se inicia o mesmo.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>