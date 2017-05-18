package br.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.dao.ContatoDao;
import br.caelum.model.Contato;

@WebServlet("/contatoslist")
public class ExibeContatos extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getContatos();

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1> LISTA DE CONTATOS");
		out.println("<table border="+1+">");
		out.println("<tr>");
		out.println("<th>Nome</th>");
		out.println("<th>Email</th>");
		out.println("<th>Endereço</th>");
		out.println("<th>Data de Nascimento</th>");
		out.println("</tr>");

		for (Contato contato : contatos) {
			out.println("<tr>");
			out.println("<td>" + contato.getNome() + "</td>");
			out.println("<td>" + contato.getEmail() + "</td>");
			out.println("<td> " + contato.getEndereco() + "</td>");
			out.println("<td>" + contato.getDataNascimento().getTime() + "</td>");
			out.println("<tr>");

		}

		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
