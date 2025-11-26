package com.senai.infoa.O.Hospital.Com.Vida.Respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.infoa.O.Hospital.Com.Vida.Models.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
    @Query(value="SELECT * FROM agendamento WHERE id_paciente = :idPaciente",nativeQuery=true)
    public List<Agendamento> listarAgendamentosDoPaciente (@Param("idPaciente") Integer idPaciente);

    @Query(value="SELECT * FROM agendamento WHERE id_medico = :idMedico",nativeQuery=true)
    public List<Agendamento> listarAgendamentosDoMedico (@Param("idMedico") Integer idMedico);
}
