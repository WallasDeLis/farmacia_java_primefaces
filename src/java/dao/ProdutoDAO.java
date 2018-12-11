/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Aluno
 */
public class ProdutoDAO {
    public List<Produto> consultar() 
	throws SQLException{// R - Read// Consultar
	List<Produto> lista = new ArrayList<Produto>();
		Connection con = FabricaPostgres.conexao();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(
		"SELECT * FROM produto");
	while (rs.next()) {
	   long id = rs.getInt("id_Produto");
	   String nome = rs.getString("nome");
           double preco = rs.getDouble("preco");
           int quantidade = rs.getInt("quantidade");
           String tipo = rs.getString("tipo");
	   Produto produto = new Produto(id,nome,preco,quantidade,tipo);
	   lista.add(produto); 
	}
	return lista;
	}
	// C - Create// Insert
public void inserir(Produto produto) 
			throws SQLException {
	// ter conexo
	Connection con = FabricaPostgres.conexao();
	// preparar declarao 'insert'
	PreparedStatement stmt = con.prepareStatement(""
			+ "INSERT INTO produto(nome,preco,quantidade,tipo) "
			+ " VALUES(?) ");
	stmt.setString(1, produto.getNome());
        stmt.setString(2, String.valueOf(produto.getPreco()));
        stmt.setString(3, String.valueOf(produto.getQuantidade()));
        stmt.setString(4, produto.getTipo());
        
	stmt.executeUpdate();
}
public void atualizar(Produto produto) throws SQLException{
	// ter conexo
	Connection con = FabricaPostgres.conexao();
	// preparar declarao 'update'
	PreparedStatement stmt = con.prepareStatement(""
			+ "UPDATE produto"
			+ " SET nome = ? "
                        + " SET preco = ?"
                        + " SET quantidade = ?"
                        + " SET tipo = ?"
			+ " WHERE id_login = ? ");
	stmt.setString(1, produto.getNome());
        stmt.setString(2, String.valueOf(produto.getPreco()));
        stmt.setString(3, String.valueOf(produto.getQuantidade()));
        stmt.setString(4, produto.getTipo());
	// executar declarao 'update'
	stmt.executeUpdate();
}
		public void excluir(Produto produto) throws SQLException{
			// ter conexo
			Connection con = FabricaPostgres.conexao();
			// preparar declarao 'delete'
			PreparedStatement stmt = con.prepareStatement(""
					+ "DELETE FROM produto"
					+ " WHERE id_produto = ? ");
			stmt.setLong(1, produto.getID());
			// executar declarao 'delete'
			stmt.executeUpdate();
		}
		
		public void excluirLista(List<Produto> produtos) throws SQLException{
			for(Produto elem: produtos) {
				excluir(elem);
			}
		}
}
