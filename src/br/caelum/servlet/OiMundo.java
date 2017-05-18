package br.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet tem o objetivo de controlar as requisições.
 * Cada um pode ser responsável por uma página.
 * 
 * Cada servlet é, portanto, um objeto Java que recebe tais requisições (request) e produz algo (response), 
 * como uma página HTML dinamicamente gerada.
 * 
 */

public class OiMundo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Primeira servlet");
		out.println("</body>");
		out.println("</html>");
	}

}
