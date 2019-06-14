package com.cibertec.dsw2.Service;

import com.cibertec.dsw2.Model.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

   ResponseEntity<Object> getAll();

   ResponseEntity<Object> getOne(Integer id);

   ResponseEntity<Object> insert(Category category);

   ResponseEntity<Object> update(Integer id, Category category);

   ResponseEntity<Object> delete(Integer id);
}
