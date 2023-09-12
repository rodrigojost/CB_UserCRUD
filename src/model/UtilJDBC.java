package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJDBC {
	static final String url =
			"string_endereco_servidor_sql";
	static final String usuario = "nome_usuario_adm";
	static final String senha = "senha_usuario_adm";
	static final String timeZone = "?useTimezone=true&serverTimezone=UTC";

	public static Connection getConnection() throws Exception{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC Driver Ok");
			con = DriverManager.getConnection(url + timeZone,usuario,senha);
			if (con != null) {
				System.out.println("Conex�o Ok");
				return con;
			} else {
				throw new Exception("A conex�o n�o foi criada!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC inv�lido");
			e.printStackTrace();
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
		}
		return con;
	}
}
