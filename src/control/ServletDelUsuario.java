package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioBD;
import view.StringsHtmlUsuario;

@WebServlet("/delUsuario")
public class ServletDelUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDelUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			StringBuilder html = new StringBuilder();
			//cria usuario de dele��o
			Usuario user = new Usuario();
			user.setE_mail(request.getParameter("e_mailUser"));
			user.setSenha(request.getParameter("senhaUser"));
			System.out.println(user.getE_mail());
			System.out.println(user.getSenha());
			//criando objeto pra dele��o no banco
			UsuarioBD usuarioBD = new UsuarioBD();
			usuarioBD.deletarUsuario(user);
			//consultar dele��o:
			Usuario UserResultado = new Usuario();
			UserResultado = usuarioBD.consultarPorEmail(user);
			
			if (UserResultado != null) {
				//montar HTML
				html.append("N�o foi poss�vel deletar! Volte...");
			} else {
				//forward para consulta
				response.sendRedirect("conUsuario.html");
			}
			//responde msg html
			response.getWriter().print(html.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("retorno vazio2");
		}
	}

}
