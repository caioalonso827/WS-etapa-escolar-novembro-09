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
}
