package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.entity.Employee;
import io.kielbi.sda.sda.jpa_17.repository.CustomCrudRepository;
import io.kielbi.sda.sda.jpa_17.repository.EmployeeSpringDataRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring-data-employees")
public class EmployeeSpringDataController  {

    private EmployeeSpringDataRepository repository;

    public EmployeeSpringDataController(EmployeeSpringDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public HttpEntity<Employee> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(e-> ResponseEntity.ok(e))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee create(@RequestBody Employee obj) {
        return repository.save(obj);
    }

    @PutMapping
    public Employee update(@RequestBody Employee obj) {
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}
