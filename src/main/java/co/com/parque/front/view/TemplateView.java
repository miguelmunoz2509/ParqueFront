/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parque.front.view;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class TemplateView implements Serializable {
    
    private final String LANG_ES = "es";
    private final String LANG_EN = "en";
    
    private String language = null;
    
    @PostConstruct
    public void init(){
        
        System.out.println(Locale.getDefault());
        
        UIViewRoot vr = FacesContext
                .getCurrentInstance()
                .getViewRoot();
        language = vr.getLocale().getLanguage();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public void onLangChange(ValueChangeEvent vc){
        UIViewRoot vr = FacesContext
                .getCurrentInstance()
                .getViewRoot();
        if(LANG_ES.equals(vc.getNewValue())){
            vr.setLocale(new Locale(LANG_ES));
        }else{
            vr.setLocale(Locale.US);            
        }
    }
    
    
}
