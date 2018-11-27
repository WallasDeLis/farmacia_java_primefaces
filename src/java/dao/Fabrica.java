package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Fabrica {
 private static final String MySQLDriver = "com.mysql.jdbc.Driver";  
 protected static Connection con;
 public static Connection conexao() 
		 throws ClassNotFoundException, SQLException {
	  if(con == null){
		  Class.forName(MySQLDriver);
	      String url = "jdbc:mysql://localhost:3306/bibliotecaonline",
	    		  nome = "root", senha = "root";
	      con = DriverManager.getConnection(url, nome, senha);  
	  }
	  return con;
   }  
}
