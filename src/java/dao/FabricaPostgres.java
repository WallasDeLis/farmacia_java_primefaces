package dao;
import java.sql.*;
public class FabricaPostgres {
 private static Connection con;
 public static Connection conexao() 
		 throws SQLException {
  if(con == null){		
  String url = "jdbc:postgresql://localhost:5432/bibliotecaonline";
  String usuario = "postgres", senha = "postgres";
  con = DriverManager.getConnection(url, usuario, senha);
  }
  return con;
 }  
 
}
