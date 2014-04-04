package br.com.sgce.controller;

import br.com.sgce.entity.Serie;
import br.com.sgce.util.FacesUtil;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class SerieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Serie serie = new Serie();

    public void cadastrar() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        session.merge(this.serie);

        this.serie = new Serie();

        String msg = "Cadastro efetuado com sucesso!";
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public Serie getSerie() {
        return serie;
    }
}
