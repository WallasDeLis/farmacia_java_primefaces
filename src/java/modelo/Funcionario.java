/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class Funcionario {
    private String usuario;

    private String senha;
    
    
    public Funcionario(String usuario, String senha){
        this.setLogin(usuario);
        this.setSenha(senha);
    }
    
    public String getLogin() {
        return usuario;
    }
    
    

    public void setLogin(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
