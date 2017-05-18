package br.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.dao.ContatoDao;
import br.caelum.model.Contato;

@WebServlet("/exclui")
public class ExcluiContato extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doDelete");
		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();

		contato.setId(Long.parseLong(request.getParameter("id")));
		System.out.println(contato.getId());

		dao.excluirContato(contato);

		response.sendRedirect("adicionar-contato.jsp");
	}

	

}
