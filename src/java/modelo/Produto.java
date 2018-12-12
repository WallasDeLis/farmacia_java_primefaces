/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author v1n7
 */

public class Produto {
    
    private long id;
    private String nome;
    private double preco;
    private long quantidade;
    private String tipo;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
     public Produto(long id, String nome,double preco,long quantidade,String tipo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }
     
     public Produto(){
         
     }

  public long getID() {
    return id;
  }

  public void setID(long id) {
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
  
  public long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(long quantidade) {
    this.quantidade = quantidade;
  } 
  
   public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  } 
}
   

