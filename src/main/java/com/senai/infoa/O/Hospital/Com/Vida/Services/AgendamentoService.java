package com.senai.infoa.O.Hospital.Com.Vida.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.O.Hospital.Com.Vida.Models.Agendamento;
import com.senai.infoa.O.Hospital.Com.Vida.Respositories.AgendamentoRepository;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void cadastrarAgendamento (Agendamento agendamento) {
        agendamentoRepository.saveAndFlush(agendamento);
    }

    public List<Agendamento> listarAgendamentoDoPaciente (Integer idPaciente) {
        return agendamentoRepository.listarAgendamentosDoPaciente(idPaciente);
    }

     public List<Agendamento> listarAgendamentoDoMedico (Integer idMedico) {
        return agendamentoRepository.listarAgendamentosDoMedico(idMedico);
    }

    public void deletarAgendamento (Integer idAgendamento) {
        agendamentoRepository.deleteById(idAgendamento);
}

     public void atualizarAgendamento (Integer idAgendamento, Agendamento agendamento) {

        if (agendamento.getDataAgendamento() != null) {agendamento.setDataAgendamento(agendamento.getDataAgendamento());}
        if (agendamento.getTratamento() != null) {agendamento.setTratamento(agendamento.getTratamento());}
        if (agendamento.getMedico() != null) {agendamento.setMedico(agendamento.getMedico());}
        if (agendamento.getIdAgendamento() != null) {agendamento.setIdAgendamento(agendamento.getIdAgendamento());} // nao pode trocar id
        if (agendamento.getPaciente() != null) {agendamento.setPaciente(agendamento.getPaciente());}
        
        agendamentoRepository.saveAndFlush(agendamento);
    }
}
