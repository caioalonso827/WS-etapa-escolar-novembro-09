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

        int custoTratamento = tratamento.getCustoTratamento();
        if (custoTratamento < 0) {throw new RuntimeException("Não pode tratamento desse valor");} //Não poder tratamento com custo menor que 0.

        tratamentoRepository.saveAndFlush(tratamento);
    }

    public List<Tratamento> listarTodosTratamentos () {
        return tratamentoRepository.findAll();
    }

    public Tratamento listarTratamentoPorId (Integer idTratamento) {
        return tratamentoRepository.findById(idTratamento).orElseThrow(()-> new RuntimeException("Não existe esse tratamento"));
    }

    public void deletarTratamento (Integer idTratamento) {
        Tratamento tratamento = tratamentoRepository.findById(idTratamento).orElseThrow(()-> new RuntimeException("Não existe esse tratamento"));

        tratamento.setDisponivel(false);
        tratamentoRepository.saveAndFlush(tratamento);
    }
}
