package com.senai.infoa.O.Hospital.Com.Vida.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Medico;

import com.senai.infoa.O.Hospital.Com.Vida.Respositories.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastrarMedico (Medico medico) {
        medicoRepository.saveAndFlush(medico);
    }

    public Medico loginMedico (String emailMedico,String senhaMedico) {
        return medicoRepository.loginMedico(emailMedico, senhaMedico);
    }

    public List<Medico> listarTodosMedicos () {
        return medicoRepository.findAll();
    }

    public Medico listarMedicoPorId (Integer idMedico) {
        return medicoRepository.findById(idMedico).orElseThrow(()-> new RuntimeException("Não existe esse medico"));
    }

    public void deletarMedico (Integer idMedico) {

        Medico medico = medicoRepository.findById(idMedico).orElseThrow(()-> new RuntimeException("Não existe esse medico"));

        medico.setAtivo(false);
        medicoRepository.saveAndFlush(medico);
}

 public void atualizarMedico (Integer idMedico, Medico medico) {


        if (medico.getNomeMedico() != null) {medico.setNomeMedico(medico.getNomeMedico());}
        if (medico.getEmailMedico() != null) {medico.setEmailMedico(medico.getEmailMedico());}
        if (medico.getSenhaMedico() != null) {medico.setSenhaMedico(medico.getSenhaMedico());}
        if (medico.getIdMedico() != null) {medico.setIdMedico(idMedico);} // nao pode trocar id
        
        medicoRepository.saveAndFlush(medico);
    }
}

