package com.cibertec.dsw2.Service.Implement;

import com.cibertec.dsw2.Model.Category;
import com.cibertec.dsw2.Repository.CategoryRepository;
import com.cibertec.dsw2.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


   @PersistenceContext
   private EntityManager em;

   @Autowired
   CategoryRepository categoryRepository;

   public ResponseEntity<Object> getAll() {
      try {
         List<Category> categories = categoryRepository.findAll();

         if (categories == null) {
            return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok().body(categories);
      } catch (Exception e) {
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> getOne(Integer id) {
      try {
         Optional<Category> category = categoryRepository.findById(id);

         if (!category.isPresent()) {
            return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok().body(category);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> insert(Category category) {
      try {
         Category entity = categoryRepository.save(category);

         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
           .buildAndExpand(entity.getNum_category_id()).toUri();

         return ResponseEntity.ok().body(entity);

      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> update(Integer id, Category category) {
      try {
         Optional<Category> entity = categoryRepository.findById(id);

         if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
         }

         category.setNum_category_id(id);
         Category cust = categoryRepository.save(category);
         return ResponseEntity.ok().body(cust);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> delete(Integer id) {

      try {
         Optional<Category> entity = categoryRepository.findById(id);
         if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
         }
         categoryRepository.deleteById(id);
         return ResponseEntity.ok().build();
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

}
