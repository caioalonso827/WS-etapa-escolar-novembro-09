package com.senai.infoa.O.Hospital.Com.Vida.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.senai.infoa.O.Hospital.Com.Vida.Models.Medico;


@Repository
public interface  MedicoRepository extends JpaRepository<Medico, Integer>{
    @Query(value="SELECT * FROM medico WHERE email_medico = :emailMedico AND senha_medico = :senhaMedico", nativeQuery=true)
    public Medico loginMedico (@Param("emailMedico") String emailMedico, @Param("senhaMedico") String senhaMedico);
}
