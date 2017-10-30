/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denis.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author prokopiukd
 */
@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable {

    private String localeCode;

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    private Map<String, Object> countries;

    @PostConstruct
    private void init() {
        countries = new HashMap<>();
        countries.put("English", Locale.ENGLISH); //label, value
        countries.put("Chinese", Locale.SIMPLIFIED_CHINESE);
        countries.put("Italian", Locale.ITALY);
    }

    public Map<String, Object> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, Object> countries) {
        this.countries = countries;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        String tmpLocale = e.getNewValue().toString();
        System.out.println("tmpLocale=" + tmpLocale);
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(tmpLocale)) {
                System.out.println("Here");
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }

}
