/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denis.common;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author prokopiukd
 */
@ManagedBean
@SessionScoped
public class DataBean implements Serializable {

    private String[] data;
    private String[] keys;
    private String selectedKey;

    @PostConstruct
    private void init() {
        data = new String[]{"A", "B", "C"};
        keys = new String[]{"ValueA", "ValueB", "ValueC"};
    }

    public void valueChangeMethod(ValueChangeEvent e){
        System.out.println("###ValueChangeEvent="+e);
    }
    
    public void action(){
        System.out.println("###Action!!!!");
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public String getSelectedKey() {
        return selectedKey;
    }

    public void setSelectedKey(String selectedKey) {
        this.selectedKey = selectedKey;
    }

}
