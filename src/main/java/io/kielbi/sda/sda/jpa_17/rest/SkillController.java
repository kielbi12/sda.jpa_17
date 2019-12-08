package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.entity.Skill;
import io.kielbi.sda.sda.jpa_17.repository.CustomCrudRepository;
import io.kielbi.sda.sda.jpa_17.repository.SkillRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skills")

public class SkillController extends AbstractCustomController<Skill, Long> {


    public SkillController(SkillRepository skillRepository) {
        super(skillRepository);
    }
}
