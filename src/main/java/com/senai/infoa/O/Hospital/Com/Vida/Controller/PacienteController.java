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


import com.senai.infoa.O.Hospital.Com.Vida.Models.Paciente;
import com.senai.infoa.O.Hospital.Com.Vida.Services.PacienteService;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarPaciente (@RequestBody Paciente paciente) {
        pacienteService.cadastrarPaciente(paciente);
        return ResponseEntity.ok("Paciente Cadastrado com sucesso!!");
    }

    @PostMapping("/Login")
    public Paciente loginPaciente (@RequestParam String emailPaciente, @RequestParam String senhaPaciente) {
        return pacienteService.loginPaciente(emailPaciente, senhaPaciente);
    }

    @GetMapping("/Listar")
    public List<Paciente> listarTodosPaciente () {
        return pacienteService.listarTodosPaciente();
    }

    @GetMapping("/ListarPorId")
    public Paciente listarPacientePorId (@RequestParam Integer idPaciente) {
        return pacienteService.listarPacientePorId(idPaciente);
    }

    @DeleteMapping("/Deletar")
    public ResponseEntity<String> deletarPaciente (@RequestParam Integer idPaciente) {
        pacienteService.deletarPaciente(idPaciente);
        return ResponseEntity.ok("Paciente Deletado!!");
    }

    @PutMapping("/Atualizar")
    public ResponseEntity<String> atualizarPaciente (@RequestParam Integer idPaciente, @RequestBody Paciente paciente) {
        pacienteService.atualizarPaciente(idPaciente, paciente);
        return ResponseEntity.ok("Atualizado com Sucesso");
    }
}
