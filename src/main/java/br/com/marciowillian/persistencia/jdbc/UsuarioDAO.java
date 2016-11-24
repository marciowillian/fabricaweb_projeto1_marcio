package br.com.marciowillian.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.marciowillian.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome, login, senha) values (?,?,?)";

		try {
			// Criando um Stattement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); // substituindo o ? pelo
													// dado do usuario
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			// Execultando o comando SQL no banco
			preparador.execute();
			// Encerando o objeto preparador
			preparador.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome = ?, login = ?, senha = ? where id = ?";

		try {
			// Criando um Stattement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); // substituindo o ? pelo
													// dado do usuario
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			// Execultando o comando SQL no banco
			preparador.execute();
			// Encerando o objeto preparador
			preparador.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id = ?";

		try {
			// Criando um Stattement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());
			// Execultando o comando SQL no banco
			preparador.execute();
			// Encerando o objeto preparador
			preparador.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			alterar(usuario);
		} else
			cadastrar(usuario);
	}

	/**
	 * Busca de um registro no banco de dados pelo numero de id do usuario
	 * 
	 * @param id
	 *            e um inteiro que presenta o numero do id do usuario a ser
	 *            buscado
	 * @return um objeto usuario quando encontra e Null quando nao encontra
	 *         registro
	 */

	public Usuario buscarPorId(Integer id) {

		String sql = "select * from usuario where id = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			// Posicionando cursor no primeiro registro
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Realiza a busca de varios registros da tabela usuario
	 * 
	 * @return Uma lista de objetos Usuarios contendo 0 elementos quanto tiver
	 *         registro ou n elementos quando encontra.
	 */

	public List<Usuario> buscarTodos() {

		String sql = "select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			ResultSet resultado = preparador.executeQuery();
			// Posicionando cursor no primeiro registro
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				// Adicionando usuario na lista
				lista.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;

	}

	public Usuario autenticar(Usuario usuConsulta){
		
		String sql = "Select * from usuario where login = ? and senha= ?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
			Usuario usuario = new Usuario();
			usuario.setId(resultado.getInt("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setLogin(resultado.getString("login"));
			usuario.setSenha(resultado.getString("senha"));
			
			return usuario;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

}
