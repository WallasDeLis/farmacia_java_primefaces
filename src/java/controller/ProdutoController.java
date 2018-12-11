/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Produto;

/**
 *
 * @author rodrigomp
 */
@ManagedBean
@ViewScoped//@RequestScoped // Para solicitações AJAX o mais aconselhável é ViewScoped ao invés de Request
public class ProdutoController implements Serializable {
    private Produto produto = new Produto();
    private List<Produto> consulta;
    private List<Produto> produtos;
    private long id;
    private String nome;
    private double preco;
    private int quantidade;
    private String tipo;
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private ProdutoDAO dao = new ProdutoDAO();
    public List<Produto> getProdutos() throws SQLException {
        if(produtos == null){
            produtos = dao.consultar();
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
    public Produto getProduto() {
        return produto;
    }
    
    public ProdutoController() {
    }

    public String exibirDados() {
        return "exibirDados";
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setConsulta(List<Produto> consulta) {
        this.consulta = consulta;
    }
    public List<Produto> getConsulta() throws SQLException {
        System.out.println("descricao:"+descricao);
        if(this.nome != null){
            produtos = getProdutos();
            consulta = new ArrayList<>();
            for(Produto elem: produtos){
                if(elem.getNome().contains(nome)){
                    this.consulta.add(elem);
                }
            }
        }
        return this.consulta;

    }
    public List<Produto> consultar() throws SQLException {
        return getConsulta();
    }
    
    public String adicionarEListar() throws SQLException {
        if(produtos == null){
            produtos = getProdutos();
        }
        System.out.println("categorias.size "+produtos.size());
        System.out.println("categoria "+produto);
        if(produtos != null){
           produtos.add(produto);
            dao.inserir(produto);
            produto = new Produto();
        }
        return "consultaCategorias";
    }
    
    public void adicionar() throws SQLException {
        if(produtos == null){
            produtos = getProdutos();
        }
        System.out.println("categorias.size "+produtos.size());
        System.out.println("categoria "+produto);
        if(produtos != null){
            produtos.add(produto);
            dao.inserir(produto);
            produto = new Produto();
        }
    }
}

