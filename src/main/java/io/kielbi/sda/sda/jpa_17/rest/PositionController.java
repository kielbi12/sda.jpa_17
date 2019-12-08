package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.entity.Position;
import io.kielbi.sda.sda.jpa_17.repository.PositionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")

public class PositionController extends AbstractCustomController<Position, Long> {

    private PositionRepository ps;

    public PositionController(PositionRepository ps) {
        super(ps);
        this.ps = ps;
    }

    @GetMapping("/findAllNames")
    public List<String> findAllNames() {
        return ps.findAllNames();
    }

    @GetMapping("/search")
    public List<Position> findByName(@RequestParam(required = false) String value) {
        return ps.findByName(value);
    }

    @GetMapping("/{id}")
    public Position findById(@PathVariable Long id) {
        return ps.findById(id);
    }

}
