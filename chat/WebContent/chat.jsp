<%@page import="br.edu.ucsal.chat.model.Mensagem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ucsal.chat.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>
</head>
<body>
	<%
		List<Usuario> usuarios;
		if (application.getAttribute("usuarios") == null) {
			application.setAttribute("usuarios", new ArrayList<Usuario>());
		}
		usuarios = (List) application.getAttribute("usuarios");
	%>
	<form action="chat" method="post">
		<% Usuario usuarioSession = (Usuario)session.getAttribute("usuario"); %>
		<h5>Usuário logado: <%=usuarioSession %></h5>
		<textarea rows="" cols="" readonly="readonly"
			style="height: 300px; width: 500px; margin-bottom: 15px;">
			<% 
				for(Mensagem mensagem : usuarioSession.getMensagens()) {
					out.print(mensagem.getHorario() + " > ");
					out.print(mensagem.getRemetente() + " : ");
					out.print(mensagem.getConteudo() + "\n");
				}
			%>

	</textarea>
		</br> <input type="text" name="mensagem" /> <input type="submit"
			value="Enviar" /> </br> <select name="usuario_select">
			<option>Selecione um amigo</option>
			<%
				for (Usuario usuario : usuarios) {
					if(!usuario.equals(session.getAttribute("usuario"))){
					
			%>
			<option value="<%=usuario%>"><%=usuario.getNome()%></option>
			<%
				}
			}
			%>
		</select>
	</form>

</body>
</html>