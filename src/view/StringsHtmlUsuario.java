package view;

public class StringsHtmlUsuario {

	public static final String conUsuario_ini_html = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<!-- HTML4 -->\r\n" + 
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
			"<!-- HTML5 -->\r\n" + 
			"<meta charset=\"utf-8\">\r\n" + 
			"<link rel=\"stylesheet\" type=\"text/css\" href=\"supervisorioCBstyle.css\"  />\r\n" + 
			"<title>Supervis�rio CleanBOX - Consulta</title>\r\n" + 
			"</head>\r\n" + 
			"	<body>\r\n" + 
			"	<ul>\r\n" + 
			"	  <li><a href=\"index.html\">In�cio</a></li>\r\n" + 
			"	  <li><a class=\"active\" href=\"conUsuario.html\">Consulta de Usu�rios</a></li>\r\n" + 
			"	  <li><a href=\"cadUsuario.html\">Cadastro de Usu�rios</a></li>\r\n" + 
			"	</ul>\r\n" + 
			"	<h3>Resultado:</h3>\r\n" + 
			"	\r\n" + 
			"	<form action=\"cadUsuario\" method=\"post\">\r\n" + 
			"	  <label for=\"nomeUser\">Nome:</label><br>\r\n" + 
			"	  <input type=\"text\" id=\"nomeUser\" name=\"nomeUser\" value=\"";

	public static final String conUsuario_fim_html = "\"><br>\r\n" + 
			"	</form> \r\n" + 
			"	\r\n" + 
			"	<h3>Para Editar ou Deletar o Usu�rio, digite sua senha atual:</h3>\r\n" + 
			"\r\n" + 
			"	<label for=\"senhaUser\">Senha:</label><br>\r\n" + 
			"	<input type=\"text\" id=\"senhaUser\" name=\"senhaUser\" placeholder=\"Digitar senha\"><br>\r\n" + 
			"	\r\n" + 
			"	<form action=\"delUsuario\" method=\"post\">\r\n" + 
			"	<input type=\"submit\" value=\"Deletar Usu�rio\">\r\n" + 
			"	</form> \r\n" + 
			"	\r\n" + 
			"	<form action=\"edtUsuario\" method=\"post\">\r\n" + 
			"	<input type=\"submit\" value=\"Editar Usu�rio\">\r\n" + 
			"	</form> \r\n" + 
			"\r\n" + 
			"	</body>\r\n" + 
			"</html>";
}

