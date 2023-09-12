package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioBD;

@WebServlet("/cadUsuario")
public class ServletCadUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			//objeto de leitura
			Usuario usuario = new Usuario();
			usuario.setNome(request.getParameter("nomeUser"));
			usuario.setSobrenome(request.getParameter("sobreNomeUser"));
			usuario.setE_mail(request.getParameter("e_mailUser"));
			usuario.setSenha(request.getParameter("senhaUser"));
			//objeto de pesquisa no banco
			UsuarioBD usuarioBD = new UsuarioBD();
			//tenta cadastrar
			if (usuarioBD.inserirUsuario(usuario)) {
				response.getWriter().print("Cadastro com sucesso");
					
			}else {
				response.getWriter().print("Erro ao registrar usuario");				
			}
		} 
		catch (IllegalArgumentException i) {
			response.getWriter().print("Dados com formato inválido");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(e.getMessage());
		}
	}
}
