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

import com.senai.infoa.O.Hospital.Com.Vida.Models.Agendamento;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Medico;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Paciente;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Tratamento;
import com.senai.infoa.O.Hospital.Com.Vida.Services.AgendamentoService;

@RestController
@RequestMapping("/Agendamento")
public class AgendamentoController {
   @Autowired
   private AgendamentoService agendamentoService;
   
    @PostMapping("/Cadastrar")
    public ResponseEntity<String> cadastrarAgendamento (@RequestBody Agendamento agendamento) {

        Tratamento tratamento = new Tratamento();
        tratamento.setIdTratamento(tratamento.getAgendamento().getIdAgendamento());
        tratamento.setAgendamento(agendamento); //Só precisa colocar o id, que já puxa as informaçoes

        Medico medico = new Medico();
        medico.setIdMedico(medico.getAgendamento().getIdAgendamento());
        medico.setAgendamento(agendamento);//Só precisa colocar o id, que já puxa as informaçoes

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(paciente.getAgendamento().getIdAgendamento());
        paciente.setAgendamento(agendamento);//Só precisa colocar o id, que já puxa as informaçoes

        agendamentoService.cadastrarAgendamento(agendamento);
        return ResponseEntity.ok("Agendamento Feito!!");
    }

    @GetMapping("/ListarAgendamentosDoPaciente")
    public List<Agendamento> listarAgendamentosDoPaciente (@RequestParam Integer idPaciente) {
        return agendamentoService.listarAgendamentoDoPaciente(idPaciente);
    }

    @GetMapping("/ListarAgendamentosDoMedico")
    public List<Agendamento> listarAgendamentosDoMedico (@RequestParam Integer idMedico) {
        return agendamentoService.listarAgendamentoDoMedico(idMedico);
    }


    @DeleteMapping("/Deletar")
    public ResponseEntity<String> deletarAgendamento (@RequestParam Integer idAgendamento) {
        agendamentoService.deletarAgendamento(idAgendamento);
        return ResponseEntity.ok("Medico Deletado!!");
    }

     @PutMapping("/Atualizar")
    public ResponseEntity<String> atualizarAgendamento (@RequestParam Integer idAgendamento, @RequestBody Agendamento agendamento) {
        agendamentoService.atualizarAgendamento(idAgendamento, agendamento);
        return ResponseEntity.ok("Atualizado com Sucesso");
    }
}
