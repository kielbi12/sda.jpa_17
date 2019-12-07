package io.kielbi.sda.sda.jpa_17.repository;


import io.kielbi.sda.sda.jpa_17.entity.Position;
import io.kielbi.sda.sda.jpa_17.entity.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository

public class ProjectRepository extends AbstractCustomCrudRepository<Project, Long> {


    public ProjectRepository(EntityManager em) {
        super(em, Project.class);
    }

    public List<Project> findByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Project> query = criteriaBuilder.createQuery(Project.class);
        Root<Project> from = query.from(Project.class);

        return em.createQuery(query.select(from)
                .where(criteriaBuilder.like(from.get("name"), "%" + name + "%")))
                .getResultList();
    }

    public List<String> findAllNames() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Path<String> name = query.from(Project.class).get("name");

        return em.createQuery(query.select(name)).getResultList();
    }
}

