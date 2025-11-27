package com.senai.infoa.O.Hospital.Com.Vida.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tratamento")
public class Tratamento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tratamento")
    private Integer idTratamento;

    @Column(name="data_criacao")
    private LocalDate dataCriacao;

    @Column(name="nome_tratamento")
    private String nomeMedico;

    @Column(name="descricao_tratamento")
    private String descricaoTratamento;

    @Column(name="custo_tratamento")
    private String custoTratamento;

    @Column(name="categoria_tratamento")
    private String categoriaTratamento;

    private Boolean disponivel = true;


    @ManyToOne
    @JsonIgnore
    private Agendamento agendamento;

    public Tratamento() {
    }

    public Tratamento(Integer idTratamento, String nomeMedico, String descricaoTratamento, String custoTratamento,
            String categoriaTratamento, Agendamento agendamento, LocalDate dataCriacao) {
        this.idTratamento = idTratamento;
        this.nomeMedico = nomeMedico;
        this.descricaoTratamento = descricaoTratamento;
        this.custoTratamento = custoTratamento;
        this.categoriaTratamento = categoriaTratamento;
        this.agendamento = agendamento;
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(Integer idTratamento) {
        this.idTratamento = idTratamento;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getDescricaoTratamento() {
        return descricaoTratamento;
    }

    public void setDescricaoTratamento(String descricaoTratamento) {
        this.descricaoTratamento = descricaoTratamento;
    }

    public String getCustoTratamento() {
        return custoTratamento;
    }

    public void setCustoTratamento(String custoTratamento) {
        this.custoTratamento = custoTratamento;
    }

    public String getCategoriaTratamento() {
        return categoriaTratamento;
    }

    public void setCategoriaTratamento(String categoriaTratamento) {
        this.categoriaTratamento = categoriaTratamento;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    
    
    
    

}
