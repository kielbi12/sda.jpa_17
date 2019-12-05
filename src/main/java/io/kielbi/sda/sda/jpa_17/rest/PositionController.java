package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.entity.Position;
import io.kielbi.sda.sda.jpa_17.repository.PositionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private PositionRepository ps;

    public PositionController(PositionRepository ps) {
        this.ps = ps;
    }

    @PostMapping
    public Position create(@RequestBody Position obj){
        return ps.create(obj);
    }

    @PutMapping
    public Position update(@RequestBody Position obj){
        return ps.update(obj);
    }

    @GetMapping
    public List<Position> findAll(){
        return ps.findAll();
    }

    @GetMapping("/findAllNames")
    public List<String> findAllNames(){
        return ps.findAllNames();
    }

    @GetMapping("/search")
    public List<Position> findByName(@RequestParam(required = false) String value){
        return ps.findByName(value);
    }

    @GetMapping("/{id}")
    public Position findById(@PathVariable Long id){
        return ps.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        ps.deleteById(id);
    }

}
