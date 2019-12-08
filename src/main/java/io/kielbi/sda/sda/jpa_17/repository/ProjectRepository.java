package io.kielbi.sda.sda.jpa_17.repository;

import io.kielbi.sda.sda.jpa_17.entity.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository

public class ProjectRepository extends AbstractCustomCrudRepository<Project, Long> {


    public ProjectRepository(EntityManager em) {
        super(em, Project.class);
    }

}

