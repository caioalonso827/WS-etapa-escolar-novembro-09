package com.senai.infoa.O.Hospital.Com.Vida.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Medico;
import com.senai.infoa.O.Hospital.Com.Vida.Services.MedicoService;

@RestController
@RequestMapping("/Medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarMedico (@RequestBody Medico medico) {
        medicoService.cadastrarMedico(medico);
        return ResponseEntity.ok("Medico Cadastrado com sucesso!!");
    }

    @PostMapping("/Login")
    public Medico loginMedico (@RequestParam String emailMedico, @RequestParam String senhaMedico) {
        return medicoService.loginMedico(emailMedico, senhaMedico);
    }

    @GetMapping("/Listar")
    public List<Medico> listarTodosMedicos () {
        return medicoService.listarTodosMedicos();
    }

    @GetMapping("/ListarPorId")
    public Medico listarMedicoPorId (@RequestParam Integer idMedico) {
        return medicoService.listarMedicoPorId(idMedico);
    }

    @DeleteMapping("/Deletar")
    public ResponseEntity<String> deletarMedico (@RequestParam Integer idMedico) {
        medicoService.deletarMedico(idMedico);
        return ResponseEntity.ok("Medico Deletado!!");
    }

    @PutMapping("/Atualizar")
    public ResponseEntity<String> atualizarMedico (@RequestParam Integer idMedico, @RequestBody Medico medico) {
        medicoService.atualizarMedico(idMedico, medico);
        return ResponseEntity.ok("Atualizado com Sucesso");
    }
}
