package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioBD;
import view.StringsHtmlUsuario;

@WebServlet("/conUsuario")
public class ServletConUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletConUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			StringBuilder html = new StringBuilder();
			//buscar usuarios no banco
			//cria usuario de pesquisa
			Usuario user = new Usuario();
			user.setE_mail(request.getParameter("e_mailUser"));
			//cria objeto para pesquisar
			UsuarioBD usuarioBD = new UsuarioBD();
			Usuario userResultado = new Usuario();
			
			userResultado = usuarioBD.consultarPorEmail(user);
			
			if (userResultado != null) {
				//montar HTML
				html.append(StringsHtmlUsuario.conUsuario_ini_html);
				//preparando a html
				html.append(userResultado.getNome());
				html.append("\"><br>\r\n" + 
						"	  \r\n" + 
						"	  <label for=\"sobreNomeUser\">Sobrenome:</label><br>\r\n" + 
						"	  <input type=\"text\" id=\"sobreNomeUser\" name=\"sobreNomeUser\" value=\"");
				html.append(userResultado.getSobrenome());
				html.append("\"><br>\r\n" + 
						"	  \r\n" + 
						"	  \r\n" + 
						"	  <label for=\"e_mailUser\">E-mail:</label><br>\r\n" + 
						"	  <input type=\"text\" id=\"e_mailUser\" name=\"e_mailUser\" value=\"");
				html.append(userResultado.getE_mail());
				//html.append(StringsHtmlUsuario.conUsuario_fim_html);
				//continuar montagem html:
				html.append("\"><br>\r\n" + 
						"	</form> \r\n" + 
						"	\r\n" + 
						"	<h3>Para Editar ou Deletar o Usu�rio, digite sua atual senha:</h3>\r\n" + 
						"	\r\n" + 
						"	<form action=\"delUsuario\" method=\"post\">\r\n" + 
						"	<label for=\"senhaUser\">Senha:</label><br>\r\n" + 
						"	<input type=\"text\" id=\"senhaUser\" name=\"senhaUser\" placeholder=\"Digitar senha\"><br>\r\n" + 
						"	\r\n" + 
						"	<input type=\"hidden\" id=\"e_mailUser\" name=\"e_mailUser\" value=\"");
				html.append(userResultado.getE_mail());
				html.append("\"><br>\r\n" + 
						"	<input type=\"submit\" value=\"Deletar Usu�rio\">\r\n" + 
						"	</form> \r\n" + 
						"	\r\n" + 
						"	<form action=\"edtUsuario\" method=\"post\">\r\n" + 
						"	<input type=\"hidden\" id=\"senhaUser\" name=\"senhaUser\" value=\"Digitar senha\"><br>\r\n" + 
						"	<input type=\"hidden\" id=\"e_mailUser\" name=\"e_mailUser\" value=\"Digitar e-mail cadastrado\"><br>\r\n" + 
						"	\r\n" + 
						"	<input type=\"submit\" value=\"Editar Usu�rio\">\r\n" + 
						"	</form> \r\n" + 
						"\r\n" + 
						"	</body>\r\n" + 
						"</html>");
			}
			else {
				//montar HTML
				html.append("Usu�rio N�o Encontrado! Volte...");
			}
		
			//responde msg html
			response.getWriter().print(html.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("retorno vazio2");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
