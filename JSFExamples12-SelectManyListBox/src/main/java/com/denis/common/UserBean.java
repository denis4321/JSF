/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denis.common;

import java.io.Serializable;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author prokopiukd
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
    private String[] usefulItems;

    public String[] getUsefulItems() {
        return usefulItems;
    }

    public void setUsefulItems(String[] usefulItems) {
        this.usefulItems = usefulItems;
    }
    
    public String getText(){
        return Arrays.toString(usefulItems);
    }
    
    
}
