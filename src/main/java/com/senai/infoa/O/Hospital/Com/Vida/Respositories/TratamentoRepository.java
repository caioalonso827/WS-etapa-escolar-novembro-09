package com.senai.infoa.O.Hospital.Com.Vida.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.O.Hospital.Com.Vida.Models.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer>{
    
}
