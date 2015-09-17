package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private static Connection myconn;

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://10.211.55.3:3306/usuario";
	private String user = "edilson";
	private String password = "123456";

	private JdbcUtils() {

		if (myconn == null) {

			try {
				Class.forName(driver);
				myconn=DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public static Connection getInstance()
	{
		if(myconn==null)
		{
			new JdbcUtils();
			System.out.println("realizando conexão !");
			
		} else {
			
			System.out.println("Conectado com sucesso !");
		}
		
		return myconn;
	}

}
