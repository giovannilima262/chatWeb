package br.edu.ucsal.chat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ucsal.chat.model.Mensagem;
import br.edu.ucsal.chat.model.Usuario;

/**
 * Servlet implementation class ChatController
 */
@WebServlet("/chat")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuarioNome = (String) request.getParameter("usuario_select");
		Usuario usuarioSession = (Usuario) request.getSession().getAttribute("usuario");
		List<Usuario> usuarios = (List) request.getServletContext().getAttribute("usuarios");
		Mensagem mensagem = mensagemUsuario(request);
		Usuario usuarioSelect = buscarUsuario(usuarios, usuarioNome);
		if (usuarioSelect == null) {
			for (Usuario usuario : usuarios) {
				usuario.getMensagens().add(mensagem);
			}
		} else {
			usuarioSelect.getMensagens().add(mensagem);
			usuarioSession.getMensagens().add(mensagem);
		}
		response.sendRedirect("chat.jsp");
	}

	private Usuario buscarUsuario(List<Usuario> usuarios, String usuarioNome) {
		for (Usuario usuario : usuarios) {
			if(usuario.getNome().equals(usuarioNome)) {
				return usuario;
			}
		}
		return null;
	}

	private Mensagem mensagemUsuario(HttpServletRequest request) {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		String mensagem = request.getParameter("mensagem");
		Mensagem mensagemUsuario = new Mensagem(usuario, mensagem);
		return mensagemUsuario;
	}

}
