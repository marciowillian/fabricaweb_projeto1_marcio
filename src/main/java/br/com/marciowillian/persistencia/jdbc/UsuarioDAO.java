package br.com.marciowillian.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.marciowillian.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
		
		try {
			//Criando um Stattement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); //substituindo o ?  pelo dado do usuario
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			//Execultando o comando SQL no banco
			preparador.execute();
			//Encerando o objeto preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void alterar(Usuario usu) {
String sql = "update usuario set nome = ?, login = ?, senha = ? where id = ?";
		
		try {
			//Criando um Stattement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); //substituindo o ?  pelo dado do usuario
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			//Execultando o comando SQL no banco
			preparador.execute();
			//Encerando o objeto preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usu){
	String sql = "delete from usuario where id = ?";
	
	try {
		//Criando um Stattement
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1, usu.getId());
		//Execultando o comando SQL no banco
		preparador.execute();
		//Encerando o objeto preparador
		preparador.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

}
