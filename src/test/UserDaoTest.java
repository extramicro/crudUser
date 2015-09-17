package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import dao.UserDAO;
import dao.UserDaoImpl;
import model.User;

public class UserDaoTest {

	static UserDAO userdao;
	static User u1, u2, u3;

	@BeforeClass
	public static void setUp() {

		userdao = new UserDaoImpl();

		u1 = new User();
		u1.setNome("Edilson");
		u1.setSenha("123456");

		u2 = new User();
		u2.setNome("Pedro");
		u2.setSenha("64723");

		u3 = new User();
		u3.setNome("Davi");
		u3.setSenha("2312899");

	}

	@Ignore @Test
	public void insereUserTest() {

		// Inserir Usuário
		userdao.insertUser(u1);
		userdao.insertUser(u2);
		userdao.insertUser(u3);

	}

	@Ignore
	@Test
	public void alteraUserTest() {

		// Alterar Usuário

		u1.setId(10);
		u1.setNome("Armando Silva");
		u1.setSenha("46328");

		userdao.updateUser(u1);

	}

	@Ignore	@Test
	public void exluiUserTest() {
		// Deletar Usuário

		userdao.deleteUser(1);
	}

	@Ignore @Test
	public void listarUserTest() {

		// Listar todos os usuários

		for (

		User user : userdao.getAllUsers())

		{
			System.out.println("Id: " + user.getId());
			System.out.println("Nome: " + user.getNome());
			System.out.println("Senha: " + user.getSenha());

		}
	}

	@Test
	public void checkUserTest() {

		assertEquals(userdao.checkUser("Edilson", "123456"), true);

	}

}
