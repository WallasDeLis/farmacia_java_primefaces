/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author rodrigomp
 */
public class Login implements Serializable {

    private long id;
    private String usuario;
    private long senha;

    public Login(Long id, String usuario,long senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Login() {        
    }
    
     public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }
    
     public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }
    
    @Override
    public String toString(){
        return usuario;
    }
}
