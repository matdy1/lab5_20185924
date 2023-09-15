package com.example.lab5.repository;

import com.example.lab5.entity.Mascotas;
import com.example.lab5.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotasRepository extends JpaRepository<Mascotas,Integer> {

}
