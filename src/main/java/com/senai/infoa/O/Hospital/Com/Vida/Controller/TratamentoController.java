package com.senai.infoa.O.Hospital.Com.Vida.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.senai.infoa.O.Hospital.Com.Vida.Models.Tratamento;
import com.senai.infoa.O.Hospital.Com.Vida.Services.TratamentoService;

@RestController
@RequestMapping("/Tratamento")
public class TratamentoController {
    @Autowired
    private TratamentoService tratamentoService;

    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarTratamento (@RequestBody Tratamento tratamento) {
        tratamentoService.cadastrarTratamento(tratamento);
        return ResponseEntity.ok("Tratamento Cadastrado com sucesso!!");
    }

    @GetMapping("/Listar")
    public List<Tratamento> listarTodosTratamentos () {
        return tratamentoService.listarTodosTratamentos();
    }

    @GetMapping("/ListarPorId")
    public Tratamento listarTratamentoPorId (@RequestParam Integer idTratamento) {
        return tratamentoService.listarTratamentoPorId(idTratamento);
    }

    @DeleteMapping("/Deletar")
    public ResponseEntity<String> deletarTratamento (@RequestParam Integer idTratamento) {
        tratamentoService.deletarTratamento(idTratamento);
        return ResponseEntity.ok("Tratamento Deletado!!");
    }
}
