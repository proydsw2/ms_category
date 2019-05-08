package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Repository.CategoryRepository;
import com.cibertec.dsw2.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository rep;


    @GetMapping(path = "/category")
    public List<Category> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = "/category/{id}")
    public Category retriveOne(@PathVariable Long id) {
        Optional<Category> category = rep.findById(id);

        return category.get();
    }

    @PostMapping(path = "/category")
    public ResponseEntity<Object> create(@RequestBody Category category) {
        Category entity = rep.save(category);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_category_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/category/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        category.setNum_category_id(id);
        rep.save(category);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/category/{id}")
    public void delete(@PathVariable Long id) {
        rep.deleteById(id);
    }
}