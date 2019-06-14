package com.cibertec.dsw2.Controller;


import com.cibertec.dsw2.Model.Category;
import com.cibertec.dsw2.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/category")
    public ResponseEntity<Object> retriveAll() {
        return categoryService.getAll();
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return categoryService.getOne(id);
    }

    @PostMapping(path = "/category")
    public ResponseEntity<Object> create(@RequestBody Category category) {
        return categoryService.insert(category);
    }

    @PutMapping(path = "/category/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping(path = "/category/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return categoryService.delete(id);
    }
}