package com.senai.infoa.O.Hospital.Com.Vida.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.infoa.O.Hospital.Com.Vida.Models.Paciente;

@Repository
public interface  PacienteRespository extends JpaRepository<Paciente, Integer> {
    @Query(value="SELECT * FROM paciente WHERE email_paciente = :emailPaciente AND senha_paciente = :senhaPaciente", nativeQuery=true)
    public Paciente loginPaciente (@Param("emailPaciente") String emailPaciente, @Param("senhaPaciente") String senhaPaciente);
}
