package com.cibertec.dsw2.Controlador;

import com.cibertec.dsw2.Repositorio.CategoryRepositorio;
import com.cibertec.dsw2.Modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "{/dsw2}")
public class CategoryControlador {

    @Autowired
    private CategoryRepositorio rep;


    @GetMapping(path = {"/category", "/category/"})
    public List<Category> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = {"/category/{id}", "/category/{id}/"})
    public Category retriveOne(@PathVariable Integer id) {
        Optional<Category> cate = rep.findById(id);

        return cate.get();
    }

    @PostMapping(path = {"/category", "/category/"})
    public ResponseEntity<Object> create(@RequestBody Category cate) {
        Category entity = rep.save(cate);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/category/{id}", "/category/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Category cate) {
        Optional<Category> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cate.setId(id);
        rep.save(cate);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/category/{id}", "/category/{id}/"})
    public void delete(@PathVariable Integer id) {
        rep.deleteById(id);
    }
}