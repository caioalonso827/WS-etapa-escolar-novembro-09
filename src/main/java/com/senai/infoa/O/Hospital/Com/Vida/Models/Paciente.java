package com.senai.infoa.O.Hospital.Com.Vida.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_paciente",unique=true)
    private Integer idPaciente;

    @Column(name="data_criacao")
    private LocalDate dataCriacao;


    @Column(name="nome_paciente")
    @Nonnull
    private String nomePaciente;

    @Column(name="cpf_paciente")
    private String cpfPaciente;

    @Column(name="email_paciente")
    private String emailPaciente;

    @Column(name="senha_paciente")
    private String senhaPaciente;

    private Boolean disponivel = true;

    @OneToOne(mappedBy="paciente",cascade=CascadeType.ALL)
    @JsonIgnore
    private Agendamento agendamento;

    public Paciente() {
    }

    public Paciente(Integer idPaciente, String nomePaciente, String cpfPaciente, String emailPaciente,
            String senhaPaciente, Agendamento agendamento, LocalDate dataCriacao) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.cpfPaciente = cpfPaciente;
        this.emailPaciente = emailPaciente;
        this.senhaPaciente = senhaPaciente;
        this.agendamento = agendamento;
        this.dataCriacao = dataCriacao;
    }



    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getSenhaPaciente() {
        return senhaPaciente;
    }

    public void setSenhaPaciente(String senhaPaciente) {
        this.senhaPaciente = senhaPaciente;
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
