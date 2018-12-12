package dao;
import java.sql.*;
public class FabricaPostgres {
 private static Connection con;
 public static Connection conexao() 
		 throws SQLException {
     if(con == null){
     try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/farmacia_db","postgres","root");
        } catch (Exception e) {
            System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
        }
  	
  //String url = "jdbc:postgresql://localhost:5432/farmacia_db";
  //String usuario = "postgres", senha = "root";
  //con = DriverManager.getConnection(url, usuario, senha);
  }
  return con;
 }  
 
}
