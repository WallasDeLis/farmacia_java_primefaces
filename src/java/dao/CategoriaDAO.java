package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;

//Classe que ter CRUD
public class CategoriaDAO {// Criar mtodo 'inserir','excluir','atualizar'
	public List<Categoria> consultar() 
	throws SQLException{// R - Read// Consultar
	List<Categoria> lista = new ArrayList<Categoria>();
		Connection con = FabricaPostgres.conexao();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(
		"SELECT * FROM categoria");
	while (rs.next()) {
	   long id = rs.getInt("idCategoria");
	   String descricao = rs.getString("descCategoria");
	   Categoria categoria = new Categoria(id, descricao);
	   lista.add(categoria); 
	}
	return lista;
	}
	// C - Create// Insert
public void inserir(Categoria categoria) 
			throws SQLException {
	// ter conexo
	Connection con = FabricaPostgres.conexao();
	// preparar declarao 'insert'
	PreparedStatement stmt = con.prepareStatement(""
			+ "INSERT INTO categoria(descCategoria) "
			+ " VALUES(?) ");
	stmt.setString(1, categoria.getDescricao());
	stmt.executeUpdate();
}
public void atualizar(Categoria categoria) throws SQLException{
	// ter conexo
	Connection con = FabricaPostgres.conexao();
	// preparar declarao 'update'
	PreparedStatement stmt = con.prepareStatement(""
			+ "UPDATE categoria"
			+ " SET descCategoria = ? "
			+ " WHERE idCategoria = ? ");
	stmt.setString(1, categoria.getDescricao());
	stmt.setLong(2, categoria.getId());
	// executar declarao 'update'
	stmt.executeUpdate();
}
		public void excluir(Categoria categoria) throws SQLException{
			// ter conexo
			Connection con = FabricaPostgres.conexao();
			// preparar declarao 'delete'
			PreparedStatement stmt = con.prepareStatement(""
					+ "DELETE FROM categoria"
					+ " WHERE idCategoria = ? ");
			stmt.setLong(1, categoria.getId());
			// executar declarao 'delete'
			stmt.executeUpdate();
		}
		public void excluirPorDescricao(Categoria categoria) throws SQLException{
			// ter conexo
			Connection con = FabricaPostgres.conexao();
			// preparar declarao 'delete'
			PreparedStatement stmt = con.prepareStatement(""
					+ "DELETE FROM categoria"
					+ " WHERE descCategoria = ? ");
			stmt.setString(1, categoria.getDescricao());
			// executar declarao 'delete'
			stmt.executeUpdate();		
		}
		public void excluirLista(List<Categoria> categorias) throws SQLException{
			for(Categoria elem: categorias) {
				excluir(elem);
			}
		}
}
