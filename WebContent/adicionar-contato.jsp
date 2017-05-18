<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="br.caelum.dao.ContatoDao"%>
<%@page import="br.caelum.model.Contato"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%-- comentário em JSP aqui: nossa primeira página JSP --%>
		<div>
			<form action="addcontato" method="post">
				Nome: <input type="text" name="nome" /><br /> E-mail: <input
					type="text" name="email" /><br /> Endereço: <input type="text"
					name="endereco" /><br /> Data Nascimento: <input type="text"
					name="dataNascimento" /><br /> <input type="submit"
					value="Gravar"/>
			</form>
		</div>
	</center>
	<br>
	<br>
	<center>
		<h1>LISTA DE CONTATOS</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getContatos();

				for (Contato contato : contatos) {
			%>
			<tr>
				<td><%=contato.getId() %></td>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getEmail()%></td>
				<td><%=contato.getEndereco()%></td>
				<td><%=contato.getDataNascimento().getTime()%></td>
				<td><a href="http://localhost:8080/fj21-agenda/exclui?id=<%= contato.getId() %>">Excluir</a></td>
			</tr>
			<%
				}
			%>
			
		</table>
	</center>
</body>
</html>