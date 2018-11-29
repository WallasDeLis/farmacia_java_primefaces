/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author De Lis
 */
@ManagedBean
public class ImagensView {
     
    private List<String> imagens;
     
    @PostConstruct
    public void init() {
        imagens = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            imagens.add("imagem" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return imagens;
    }
}
