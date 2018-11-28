/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Usuario;

/**
 *
 * @author De Lis
 */
@ManagedBean
public class loginMB {
  private Usuario usuario = new Usuario();

  public String doEfetuarLogin() {
    if("admin".equals(usuario.getLogin())
            && "123".equals(usuario.getSenha())) {
      return "manutencao";
    } else {
      /* Cria uma mensagem. */
      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
      FacesContext.getCurrentInstance().addMessage("erro", msg);
      return null;
    }
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }  
}
