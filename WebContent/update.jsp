<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%@ page import="dao.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		int idd = Integer.parseInt(id);
		String nome = null;
		String senha = null;
		UserDAO userDAO = new UserDaoImpl();

		for (User u : userDAO.getAllUsers()) {
			if (u.getId() == idd) {
				nome = u.getNome();
				senha = u.getSenha();
			}
		}
	%>

	<form action="UserController" method="POST">
		<input type="hidden" name="id" value="<%=idd %>"> 
		<label for="txtNome">Nome:</label> 
		<input type="text" name="txtNome" value="<%=nome %>" /> 
		<label for="txtSenha">Senha:</label> 
		<input type="text" name="txtSenha" value="<%=senha %>" /> 
		
		<input type="hidden" name="action" value="isUpdated"/> <input type="submit" value="Alterar" />


	</form>
</body>
</html>