package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Login;

//Classe que ter CRUD
public class LoginDAO {// Criar mtodo 'inserir','excluir','atualizar'
	public List<Login> consultar() 
	throws SQLException{// R - Read// Consultar
	List<Login> lista = new ArrayList<Login>();
		Connection con = FabricaPostgres.conexao();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(
		"SELECT * FROM login");
	while (rs.next()) {
	   long id = rs.getInt("id_login");
	   String usuario = rs.getString("usuario");
           long senha = rs.getLong("senha");
	   Login login = new Login(id,usuario,senha);
	   lista.add(login); 
	}
	return lista;
	}
	// C - Create// Insert
public void inserir(Login login) 
			throws SQLException {
	// ter conexo
	Connection con = FabricaPostgres.conexao();
	// preparar declarao 'insert'
	PreparedStatement stmt = con.prepareStatement(""
			+ "INSERT INTO login(usuario) "
			+ " VALUES(?) ");
	stmt.setString(1, login.getUsuario());
	stmt.executeUpdate();
}
public void atualizar(Login login) throws SQLException{
	// ter conexo
	Connection con = FabricaPostgres.conexao();
	// preparar declarao 'update'
	PreparedStatement stmt = con.prepareStatement(""
			+ "UPDATE login"
			+ " SET Usuario = ? "
                        + " SET senha = ?"
			+ " WHERE id_login = ? ");
	stmt.setString(1, login.getUsuario());
	stmt.setLong(2, login.getSenha());
        stmt.setLong(3, login.getId());
	// executar declarao 'update'
	stmt.executeUpdate();
}
		public void excluir(Login login) throws SQLException{
			// ter conexo
			Connection con = FabricaPostgres.conexao();
			// preparar declarao 'delete'
			PreparedStatement stmt = con.prepareStatement(""
					+ "DELETE FROM login"
					+ " WHERE id_login = ? ");
			stmt.setLong(1, login.getId());
			// executar declarao 'delete'
			stmt.executeUpdate();
		}
		public void excluirPorDescricao(Login login) throws SQLException{
			// ter conexo
			Connection con = FabricaPostgres.conexao();
			// preparar declarao 'delete'
			PreparedStatement stmt = con.prepareStatement(""
					+ "DELETE FROM login"
					+ " WHERE usuario = ? ");
			stmt.setString(1, login.getUsuario());
			// executar declarao 'delete'
			stmt.executeUpdate();		
		}
		public void excluirLista(List<Login> logins) throws SQLException{
			for(Login elem: logins) {
				excluir(elem);
			}
		}
}
