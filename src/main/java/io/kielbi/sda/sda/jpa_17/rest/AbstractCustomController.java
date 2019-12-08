package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.repository.CustomCrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCustomController<T, ID> {

    private CustomCrudRepository<T, ID> crudRepository;

    public AbstractCustomController(CustomCrudRepository<T, ID> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @GetMapping
    public List<T> findAll() {
        return crudRepository.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id) {
        return crudRepository.findById(id);
    }

    @PostMapping
    public T create(@RequestBody T obj) {
        return crudRepository.create(obj);
    }

    @PutMapping
    public T update(@RequestBody T obj) {
        return crudRepository.update(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {
        crudRepository.deleteById(id);
    }


}
