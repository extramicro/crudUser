<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir</title>
</head>
<body>

<form action="UserController" method="POST">
<input type="hidden"name="action" value="isInserted"/>
<label for="txtNome">Nome: </label>
<input type="text" name="txtNome" value=""/>

<label for="txtSenha">Senha: </label>
<input type="password" name="txtSenha" value=""/>

<input type="submit" value="Inserir Usuário"/>


</form>

</body>
</html>