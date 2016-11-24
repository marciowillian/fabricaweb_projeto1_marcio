package br.com.marciowillian;

import java.util.List;

import br.com.marciowillian.persistencia.entidade.Usuario;
import br.com.marciowillian.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		//testeAlterar();
		//testwCadastrar();
		// testeSalvar ();
		//testeBuscarPorId();
		testeAltenticar();
		//testeBuscarTodos();
	}

	private static void testeAltenticar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		usu.setLogin("marciowillian");
		usu.setSenha("willianmarcio");
		
		Usuario usuRetorno = usuarioDAO.autenticar(usu);
		
		System.out.println(usuRetorno);
		
	}

	private static void testeBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		for (Usuario u: lista){
		System.out.println(u);
		}
	}
	
	private static void testeBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(5);

		System.out.println(usuario);

	}

	

	public static void testeAlterar() {
		// Criando o Usuario
		Usuario usu = new Usuario();
		usu.setId(1);
		usu.setNome("marcio");
		usu.setLogin("marciowillian");
		usu.setSenha("willianmarcio");

		// Cadastrando Usuario no Banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Usuario alterado com sucesso!!!");
	}

	public static void testeCadastrar() {
		// Criando o Usuario
		Usuario usu = new Usuario();
		usu.setNome("mr");
		usu.setLogin("mrrobot");
		usu.setSenha("robotmr");

		// Cadastrando Usuario no Banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com sucesso!!!");
	}

	public static void testeSalvar() {

		Usuario usuario = new Usuario();
		//usuario.setId();
		usuario.setNome("lucas");
		usuario.setLogin("lucasserejo");
		usuario.setSenha("serejolucas");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);

		System.out.println("Usuario salvo com sucesso!!!");

	}

}
