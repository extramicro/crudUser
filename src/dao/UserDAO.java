package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	public void insertUser(User u);
	public void updateUser(User u);
	public void deleteUser(int id);
	public List<User> getAllUsers();
	public boolean checkUser(String nome, String senha);
	

}
