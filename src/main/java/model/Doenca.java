package model;

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

@Entity(name="Doenca")
public class Doenca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "doenca_sintomas", 
        joinColumns = { @JoinColumn(name = "doenca_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "sintoma_id") }
    )
    private Set<Sintoma> sintomas;

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

}
