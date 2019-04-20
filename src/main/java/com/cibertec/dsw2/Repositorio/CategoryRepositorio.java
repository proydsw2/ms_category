package com.cibertec.dsw2.Repositorio;

import com.cibertec.dsw2.Modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositorio extends JpaRepository<Category,Integer> {



}