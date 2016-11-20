package br.com.marciowillian;

import br.com.marciowillian.persistencia.entidade.Usuario;
import br.com.marciowillian.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testeCadastrar();
	}
	
	public static void testeExcluir(){
		//Excluindo o Usuario
				Usuario usu = new Usuario();
				usu.setId(8);
				
				//Excluindo o Usuario no Banco
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.excluir(usu);
				
				System.out.println("Usuario excluido com sucesso!!!");
	}
	
	public static void testeAlterar(){
		//Criando o Usuario
				Usuario usu = new Usuario();
				usu.setId(1);
				usu.setNome("marcio");
				usu.setLogin("marciowillian");
				usu.setSenha("willianmarcio");
				
				//Cadastrando Usuario no Banco
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.alterar(usu);
				
				System.out.println("Usuario alterado com sucesso!!!");
	}
	
	public static void testeCadastrar(){
		//Criando o Usuario
				Usuario usu = new Usuario();
				usu.setNome("mr");
				usu.setLogin("mrrobot");
				usu.setSenha("robotmr");
				
				//Cadastrando Usuario no Banco
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.cadastrar(usu);
				
				System.out.println("Cadastrado com sucesso!!!");
	}
	
}
