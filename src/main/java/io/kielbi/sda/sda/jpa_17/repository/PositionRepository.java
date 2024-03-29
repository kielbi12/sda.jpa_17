package io.kielbi.sda.sda.jpa_17.repository;

import io.kielbi.sda.sda.jpa_17.entity.Position;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository

public class PositionRepository extends AbstractCustomCrudRepository<Position, Long> {


    public PositionRepository(EntityManager em) {
        super(em, Position.class);
    }

    public List<Position> findByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Position> query = criteriaBuilder.createQuery(Position.class);
        Root<Position> from = query.from(Position.class);

        return em.createQuery(query.select(from)
                .where(criteriaBuilder.like(from.get("name"), "%" + name + "%")))
                .getResultList();
    }

    public List<String> findAllNames() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Path<String> name = query.from(Position.class).get("name");

        return em.createQuery(query.select(name)).getResultList();
    }
}
