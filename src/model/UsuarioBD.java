package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioBD {

	public Usuario consultarPorEmail (Usuario s) throws Exception {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		Connection con = null;
		String sql ="SELECT id_user, nome_user, sobrenome_user, e_mail FROM usuarios WHERE e_mail = ?";
		try {
			con = UtilJDBC.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, s.getE_mail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id_user"));
				usuario.setNome(rs.getString("nome_user"));
				usuario.setSobrenome(rs.getString("sobrenome_user"));
				usuario.setE_mail(rs.getString("e_mail"));
			}
		} catch (Exception e ) {
			System.out.println(e);
			System.out.println("retorno vazio");
			usuario = new Usuario();
		}
		finally {
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close();}
		}
		return usuario;
	}
	
	public boolean inserirUsuario(Usuario user) throws Exception {
		boolean retorno = false;
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "INSERT INTO usuarios(nome_user, sobrenome_user, e_mail, senha)"
				+ "	VALUES (?, ?, ?, ?) ";
		try {
			con = UtilJDBC.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getSobrenome());
			stmt.setString(3, user.getE_mail());
			stmt.setString(4, user.getSenha());
			stmt.executeUpdate();
			retorno = true;
		} 
		catch (Exception e ) {
			System.out.println(e);
		} finally {
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close();}
		}
		return retorno; 
	}
	
	public boolean deletarUsuario(Usuario user) throws Exception {
		boolean retorno = false;
		PreparedStatement stmt = null;
		Connection con = null;
		String sql = "DELETE FROM usuarios WHERE e_mail = ? AND senha = ?";
		try {
			con = UtilJDBC.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getE_mail());
			stmt.setString(2, user.getSenha());
			stmt.executeUpdate();
			retorno = true;
		} 
		catch (Exception e ) {
			System.out.println(e);
		} finally {
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close();}
		}
		return retorno; 
	}
	
	public boolean editarUsuario(Usuario atualUser, Usuario novoUser) throws Exception{
		boolean resultado = false;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios SET"
				+ " nome_user = ?,"
				+ " sobrenome_user = ?, "
				+ " e_mail = ?, "
				+ " senha = ? "
				+ " WHERE e_mail = ? ";
		try {
			con = UtilJDBC.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, novoUser.getNome());
			stmt.setString(2, novoUser.getSobrenome());
			stmt.setString(3, novoUser.getE_mail());
			stmt.setString(4, novoUser.getSenha());
			stmt.setString(5, atualUser.getE_mail());
			stmt.executeUpdate();
			resultado = true;
		} catch (Exception e) { 
			System.out.println(e);
		} finally { 
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		return resultado;
	}
	
	public boolean consultaCadastro(Usuario consulta) throws Exception{
		boolean existe = false;
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM usuarios"
				+ " WHERE e_mail = ? "
				+ " AND senha = ? ";
		try {
			con = UtilJDBC.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, consulta.getE_mail());
			stmt.setString(2, consulta.getSenha());
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs.next());
			if(rs.first()){
				existe = true;	
			}
		} catch (Exception e) { 
			System.out.println(e);
		} finally { 
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		return existe;
	}
}
