package com.senai.infoa.O.Hospital.Com.Vida.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Tratamento;
import com.senai.infoa.O.Hospital.Com.Vida.Respositories.TratamentoRepository;

@Service
public class TratamentoService {
    @Autowired
    private TratamentoRepository tratamentoRepository;
    
    public void cadastrarTratamento (Tratamento tratamento) {
        tratamentoRepository.saveAndFlush(tratamento);
    }

    public List<Tratamento> listarTodosTratamentos () {
        return tratamentoRepository.findAll();
    }

    public void deletarTratamento (Integer idTratamento) {
        tratamentoRepository.deleteById(idTratamento);
    }
}
