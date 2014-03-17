package br.com.sgce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funciionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fun_id")
    private long id;    
    @Column(name = "fun_nome",nullable = false, length = 50)
    private String nome;
    @Column(name = "fun_endereco",nullable = false, length = 50)
    private String endereco; 
    @Enumerated(EnumType.STRING)
    @Column(name = "fun_tip_funcionario",nullable = false, length = 15)
    private TipoFuncionario tipo;
    @OneToOne
    private List<Estado> estado = new ArrayList<>();
    @OneToOne
    private List<Cidade> cidade = new ArrayList<>();
    @OneToOne
    private List<Bairro> bairro = new ArrayList<>();

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }    
    
    public List<Estado> getEstado() {
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }

    public List<Bairro> getBairro() {
        return bairro;
    }

    public void setBairro(List<Bairro> bairro) {
        this.bairro = bairro;
    }
           
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
