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

    public void deletarPaciente (Integer idPaciente) {
        pacienteRespository.deleteById(idPaciente);
    }
}
