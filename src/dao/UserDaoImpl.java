package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import utils.JdbcUtils;

public class UserDaoImpl implements UserDAO {

	JdbcUtils con;
	ResultSet rs = null;

	@Override
	public void insertUser(User u) {

		String sql = "insert into db_user(nome,senha) values (?,?)";
		try {
			PreparedStatement ps = con.getInstance().prepareStatement(sql);

			ps.setString(1, u.getNome());
			ps.setString(2, u.getSenha());

			int i = ps.executeUpdate();

			if (i != 0) {

				System.out.println("Usuário inserido com sucesso !");

			} else {

				System.out.println("Erro ao inserir usuário !");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User u) {

		String sql = "update db_user set nome=?,senha=? where id=?";
		try {
			PreparedStatement ps = con.getInstance().prepareStatement(sql);

			ps.setString(1, u.getNome());
			ps.setString(2, u.getSenha());
			ps.setInt(3, u.getId());

			int i = ps.executeUpdate();

			if (i != 0) {

				System.out.println("Usuário alterado com sucesso !");

			} else {

				System.out.println("Erro ao alterar usuário !");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int id) {

		String sql = "delete from db_user where id=?";
		try {
			PreparedStatement ps = con.getInstance().prepareStatement(sql);

			ps.setInt(1, id);
			
			int i = ps.executeUpdate();

			if (i != 0) {

				System.out.println("Usuário excluído com sucesso !");

			} else {

				System.out.println("Erro ao excluir usuário !");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {

		String sql = "select * from db_user";
		List<User> ListUsers = new ArrayList<User>();
		
		
		PreparedStatement ps;
		try {
			ps = con.getInstance().prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				ListUsers.add(u);
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ListUsers;

	}

	@Override
	public boolean checkUser(String nome, String senha) {
		
PreparedStatement ps;

		try {
	ps = con.getInstance().prepareStatement("select nome,senha from db_user where nome = ? and senha = ?");
	ps.setString(1, nome);
	ps.setString(2, senha);
	
	
	if(ps.executeQuery().next())
	{
		
		return true;
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
		return false;
	}

}
