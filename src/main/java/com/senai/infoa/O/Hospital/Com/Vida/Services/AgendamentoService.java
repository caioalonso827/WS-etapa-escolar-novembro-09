package com.senai.infoa.O.Hospital.Com.Vida.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.O.Hospital.Com.Vida.Models.Agendamento;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Medico;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Paciente;
import com.senai.infoa.O.Hospital.Com.Vida.Respositories.AgendamentoRepository;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void cadastrarAgendamento (Agendamento agendamento) {

        Paciente paciente = agendamento.getPaciente();
        if (paciente.getDisponivel() != true) {throw  new RuntimeException("Esse paciente não está ativo");} //Não deixar paciente inativo fazer agendamento

        Medico med = agendamento.getMedico();
        if (med.getAtivo() != true) {throw new RuntimeException("Esse médico está desativado");} // Não deixar medico desativado receber agendamento
        

        
        
        //int medico = agendamentoRepository.agendarMesmaData(agendamento.getMedico().getIdMedico(), agendamento.getDataAgendamento());
        //if (medico > 0) {throw new RuntimeException("Já tem agendamento nessas data para esse médico");} //Mão pode agendar na mesma data para o mesmo medico.

        agendamentoRepository.saveAndFlush(agendamento);
    }

    public List<Agendamento> listarAgendamentoDoPaciente (Integer idPaciente) {
        return agendamentoRepository.listarAgendamentosDoPaciente(idPaciente);
    }

     public List<Agendamento> listarAgendamentoDoMedico (Integer idMedico) {
        return agendamentoRepository.listarAgendamentosDoMedico(idMedico);
    }

    public void desativarAgendamento (Integer idAgendamento) {

        Agendamento agendamento = agendamentoRepository.findById(idAgendamento).orElseThrow(()-> new RuntimeException("Não existe esse agendamento"));

        agendamento.setAtivo(false);
        agendamentoRepository.saveAndFlush(agendamento);

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
