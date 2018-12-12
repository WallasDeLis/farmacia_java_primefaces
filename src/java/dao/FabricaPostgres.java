package dao;
import java.sql.*;
public class FabricaPostgres {
 private static Connection con;
 public static Connection conexao() 
		 throws SQLException {
  if(con == null){		
  String url = "jdbc:postgresql://localhost:5432/farmacia_db";
  String usuario = "postgres", senha = "ROOT";
  con = DriverManager.getConnection(url, usuario, senha);
  }
  return con;
 }  
 
}
