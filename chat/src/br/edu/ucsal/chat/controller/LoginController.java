package br.edu.ucsal.chat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ucsal.chat.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios;
		if(request.getServletContext().getAttribute("usuarios") == null){
			request.getServletContext().setAttribute("usuarios", new ArrayList<Usuario>());
		}
		usuarios = (List) request.getServletContext().getAttribute("usuarios");
		Usuario usuario = new Usuario((String) request.getParameter("usuario"), new ArrayList<>());
		usuarios.add(usuario);
		request.getSession().setAttribute("usuario", usuario);
		response.sendRedirect("chat.jsp");
	}

}
