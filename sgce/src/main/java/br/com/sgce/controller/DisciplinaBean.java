package br.com.sgce.controller;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.util.FacesUtil;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class DisciplinaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Disciplina disciplina = new Disciplina();

    public void cadastrar() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        session.merge(this.disciplina);

        this.disciplina = new Disciplina();

        String msg = "Cadastro efetuado com sucesso!";
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
