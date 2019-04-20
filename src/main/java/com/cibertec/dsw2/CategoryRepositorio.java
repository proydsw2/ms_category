package com.cibertec.dsw2;

import com.cibertec.dsw2.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositorio extends JpaRepository<Category,Integer> {



}