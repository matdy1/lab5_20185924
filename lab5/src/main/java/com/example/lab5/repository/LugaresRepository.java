package com.example.lab5.repository;

import com.example.lab5.entity.Lugares;
import com.example.lab5.entity.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LugaresRepository extends JpaRepository<Lugares,Integer> {

}