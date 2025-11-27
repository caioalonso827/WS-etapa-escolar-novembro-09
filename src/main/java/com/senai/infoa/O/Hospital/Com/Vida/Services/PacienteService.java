package com.senai.infoa.O.Hospital.Com.Vida.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.senai.infoa.O.Hospital.Com.Vida.Models.Paciente;
import com.senai.infoa.O.Hospital.Com.Vida.Respositories.PacienteRespository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRespository pacienteRespository;

    public void cadastrarPaciente (Paciente paciente) {
        pacienteRespository.saveAndFlush(paciente);
    }

    public Paciente loginPaciente (String emailPaciente,String senhaPaciente) {
        return pacienteRespository.loginPaciente(emailPaciente, senhaPaciente);
    }

    public List<Paciente> listarTodosPaciente () {
        return pacienteRespository.findAll();
    }

    public Paciente listarPacientePorId (Integer idPaciente) {
        return pacienteRespository.findById(idPaciente).orElseThrow(()-> new RuntimeException("Não existe esse Paciente"));
    }

    public void deletarPaciente (Integer idPaciente) {
        Paciente paciente = pacienteRespository.findById(idPaciente).orElseThrow(()-> new RuntimeException("Não existe esse paciente"));

        paciente.setDisponivel(false);
        pacienteRespository.saveAndFlush(paciente);
    }

    public void atualizarPaciente (Integer idPaciente, Paciente paciente) {

        if (paciente.getNomePaciente() != null) {paciente.setNomePaciente(paciente.getNomePaciente());}
        if (paciente.getSenhaPaciente() != null) {paciente.setSenhaPaciente(paciente.getSenhaPaciente());}
        if (paciente.getCpfPaciente() != null) {paciente.setCpfPaciente(paciente.getSenhaPaciente());}
        if (paciente.getIdPaciente() != null) {paciente.setIdPaciente(idPaciente);} // nao pode trocar id
        
        pacienteRespository.saveAndFlush(paciente);
    }
}
