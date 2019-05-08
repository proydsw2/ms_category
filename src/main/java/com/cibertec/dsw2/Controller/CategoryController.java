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
@RequestMapping(path = "{/dsw2}")
public class CategoryController {

    @Autowired
    private CategoryRepository rep;


    @GetMapping(path = {"/category", "/category/"})
    public List<Category> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = {"/category/{id}", "/category/{id}/"})
    public Category retriveOne(@PathVariable Long id) {
        Optional<Category> cate = rep.findById(id);

        return cate.get();
    }

    @PostMapping(path = {"/category", "/category/"})
    public ResponseEntity<Object> create(@RequestBody Category cate) {
        Category entity = rep.save(cate);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_category_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/category/{id}", "/category/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Category cate) {
        Optional<Category> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cate.setNum_category_id(id);
        rep.save(cate);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/category/{id}", "/category/{id}/"})
    public void delete(@PathVariable Long id) {
        rep.deleteById(id);
    }
}