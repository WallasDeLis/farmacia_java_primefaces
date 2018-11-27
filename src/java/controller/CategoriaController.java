/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoriaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;

/**
 *
 * @author rodrigomp
 */
@ManagedBean
@ViewScoped//@RequestScoped // Para solicitações AJAX o mais aconselhável é ViewScoped ao invés de Request
public class CategoriaController implements Serializable {
    private Categoria categoria = new Categoria();
    private List<Categoria> consulta;
    private List<Categoria> categorias;
    private String descricao;
    private CategoriaDAO dao = new CategoriaDAO();
    public List<Categoria> getCategorias() throws SQLException {
        if(categorias == null){
            categorias = dao.consultar();
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    
    public CategoriaController() {
    }

    public String exibirDados() {
        return "exibirDados";
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setConsulta(List<Categoria> consulta) {
        this.consulta = consulta;
    }
    public List<Categoria> getConsulta() throws SQLException {
        System.out.println("descricao:"+descricao);
        if(this.descricao != null){
            categorias = getCategorias();
            consulta = new ArrayList<>();
            for(Categoria elem: categorias){
                if(elem.getDescricao().contains(descricao)){
                    this.consulta.add(elem);
                }
            }
        }
        return this.consulta;

    }
    public List<Categoria> consultar() throws SQLException {
        return getConsulta();
    }
    
    public String adicionarEListar() throws SQLException {
        if(categorias == null){
            categorias = getCategorias();
        }
        System.out.println("categorias.size "+categorias.size());
        System.out.println("categoria "+categoria);
        if(categorias != null){
            categorias.add(categoria);
            dao.inserir(categoria);
            categoria = new Categoria();
        }
        return "consultaCategorias";
    }
    
    public void adicionar() throws SQLException {
        if(categorias == null){
            categorias = getCategorias();
        }
        System.out.println("categorias.size "+categorias.size());
        System.out.println("categoria "+categoria);
        if(categorias != null){
            categorias.add(categoria);
            dao.inserir(categoria);
            categoria = new Categoria();
        }
    }
}

