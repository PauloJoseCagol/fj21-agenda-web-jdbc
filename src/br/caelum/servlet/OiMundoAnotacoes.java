package br.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Um servlet pode ser chamado também com anotações.
 * @WebServlet
 * Sem precisar implementar caminho e mapping no web.xml.
 * Muito mais pratico e ainda podendo passar parametros com valores de inicialização
 * nas request do resvlet.
 * 
 * Isso foi implementado apartir do Servlets 3.0.
 */

//@WebServlet("/oiAnot")
//@WebServlet(name = "MinhaServlet2", urlPatterns = { "/oiAnot", "/olaAnot" })
@WebServlet(name = "OiServlet3", urlPatterns = { "/oiAnot" }, initParams = {
		@WebInitParam(name = "param1", value = "value1"), @WebInitParam(name = "param2", value = "value2") })
public class OiMundoAnotacoes extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String param1;
	private String param2;
	
	//Para conseguir usar os parametros de inicialização precisa sobrescrever o método init()
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//Como se fossem getters pegando os parametros que iniciam junto com o servlet.
		this.param1 = config.getInitParameter("param1");
		this.param2 = config.getInitParameter("param2");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Segunda servlet com anotações<br>");
		out.println("Parametro1 : "+param1+"<br>");
		out.println("Parametro2 : "+param2);
		out.println("</body>");
		out.println("</html>");

	}

}
