package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioBD;

@WebServlet("/edtUsuario")
public class ServletEdtUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEdtUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			Usuario atualUser = new Usuario();
			Usuario futuroUser = new Usuario();
			//coleta dados atual cadastro
			atualUser.setE_mail(request.getParameter("oldE_mailUser"));
			atualUser.setSenha(request.getParameter("oldSenhaUser"));
			//coleta dados para cadastrar
			futuroUser.setNome(request.getParameter("nomeUser"));
			futuroUser.setSobrenome(request.getParameter("sobreNomeUser"));
			futuroUser.setE_mail(request.getParameter("e_mailUser"));
			futuroUser.setSenha(request.getParameter("senhaUser"));
			//verifica se existe cadastro
			UsuarioBD usuarioConsulta =  new UsuarioBD();
			if(usuarioConsulta.consultaCadastro(atualUser)) {
				usuarioConsulta.editarUsuario(atualUser, futuroUser);
				response.getWriter().print("Edição realizada com sucesso");
			}else {
				response.getWriter().print("Erro ao editar usuário, cadastro não encontrado");
			}
		} catch (IllegalArgumentException i) {
			response.getWriter().print("Data ou valor com formato inválido");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(e.getMessage());
		}
	}

}
