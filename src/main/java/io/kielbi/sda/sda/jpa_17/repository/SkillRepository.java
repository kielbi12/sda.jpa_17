package io.kielbi.sda.sda.jpa_17.repository;

import io.kielbi.sda.sda.jpa_17.entity.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Repository
public class SkillRepository extends AbstractCustomCrudRepository<Skill, Long> {


    public SkillRepository(EntityManager em) {
        super(em, Skill.class);
    }
}
