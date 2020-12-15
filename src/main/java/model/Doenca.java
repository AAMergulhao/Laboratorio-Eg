package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity(name="Doenca")
public class Doenca implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Expose(serialize = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Expose(serialize = true)
    @Column(name = "nome")
    private String nome;

    @Expose(serialize = true)
    @Column(name = "descricao")
    private String descricao;

    @Expose(serialize = true)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "doenca_sintomas", 
        joinColumns = { @JoinColumn(name = "doenca_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "sintoma_id") }
    )
    private Set<Sintoma> sintomas;

    @Expose(serialize = true)
    @OneToMany(mappedBy = "doenca", fetch = FetchType.EAGER)
    private Set<Ocorrencia> ocorrencias;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(Set<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public Set<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(Set<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

}
