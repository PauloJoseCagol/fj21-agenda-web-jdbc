package br.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.dao.ContatoDao;
import br.caelum.model.Contato;

@WebServlet("/addcontato")
public class AdicionaContato extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ContatoDao dao = new ContatoDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);

		} catch (java.text.ParseException ex) {
			out.println("Erro de conversão da data\n" + ex);
			return;
		}

		Contato contato = new Contato();
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setDataNascimento(dataNascimento);

		dao.addContato(contato);

		response.sendRedirect("adicionar-contato.jsp");

	}

}
