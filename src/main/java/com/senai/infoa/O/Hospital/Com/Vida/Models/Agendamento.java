package com.senai.infoa.O.Hospital.Com.Vida.Models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_agendamento")
    private Integer idAgendamento;

    @Column(name="data_agendamento")
    private LocalDate dataAgendamento;

    @OneToMany
    @JoinColumn (name="tratamento_id")
    private List<Tratamento> tratamento;

    @OneToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name="medico_id")
    private Medico medico;

    @Column(name="data_criacao")
    private LocalDate dataCriacao;

    private Boolean ativo = true;


    
    public Agendamento() {
    }

    
    public Agendamento(Integer idAgendamento, List<Tratamento> tratamento, Paciente paciente, Medico medico, LocalDate dataCriacao) {
        this.idAgendamento = idAgendamento;
        this.tratamento = tratamento;
        this.paciente = paciente;
        this.medico = medico;
        this.dataCriacao = dataCriacao;
    }

    


    


    public Agendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }



    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }



    public List<Tratamento> getTratamento() {
        return tratamento;
    }



    public void setTratamento(List<Tratamento> tratamento) {
        this.tratamento = tratamento;
    }



    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }



    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
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
