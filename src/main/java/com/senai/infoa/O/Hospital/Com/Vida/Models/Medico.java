package com.senai.infoa.O.Hospital.Com.Vida.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medico")
public class Medico {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_medico",unique=true)
    private Integer idMedico;

    @Column(name="data_criacao")
    private LocalDate dataCriacao;

    @Column(name="nome_medico")
    private String nomeMedico;

    @Column(name="cpf_medico")
    private String cpfMedico;

    @Column(name="email_medico")
    private String emailMedico;

    @Column(name="senha_medico")
    private String senhaMedico;

    @Column(name="especializacao_medico")
    private String especializacaoMedico;

    @Column(name="turno_medico")
    private String turnoMedico;

    @OneToOne (mappedBy="medico",cascade=CascadeType.ALL)
    @JsonIgnore
    private Agendamento agendamento;

    private Boolean ativo = true;

    public Medico() {
    }

    public Medico(Integer idMedico, String nomeMedico, String cpfMedico, String emailMedico, String senhaMedico,
            String especializacaoMedico, String turnoMedico, Agendamento agendamento, LocalDate dataCriacao) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.cpfMedico = cpfMedico;
        this.emailMedico = emailMedico;
        this.senhaMedico = senhaMedico;
        this.especializacaoMedico = especializacaoMedico;
        this.turnoMedico = turnoMedico;
        this.agendamento = agendamento;
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public String getSenhaMedico() {
        return senhaMedico;
    }

    public void setSenhaMedico(String senhaMedico) {
        this.senhaMedico = senhaMedico;
    }

    public String getEspecializacaoMedico() {
        return especializacaoMedico;
    }

    public void setEspecializacaoMedico(String especializacaoMedico) {
        this.especializacaoMedico = especializacaoMedico;
    }

    public String getTurnoMedico() {
        return turnoMedico;
    }

    public void setTurnoMedico(String turnoMedico) {
        this.turnoMedico = turnoMedico;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    
    
    
}
