package io.kielbi.sda.sda.jpa_17.repository;

import io.kielbi.sda.sda.jpa_17.entity.Position;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class PositionRepository implements CustomCrudRepository<Position, Long> {


    private EntityManager em;

    public PositionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Position> findAll() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Position> query = criteriaBuilder.createQuery(Position.class);
        Root<Position> from = query.from(Position.class);


        return em.createQuery(query.select(from)).getResultList() ;
    }

    public List<String> findAllNames(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Path<String> name = query.from(Position.class).get("name");

        return em.createQuery(query.select(name)).getResultList();
    }

    public List<Position> findByName(String name){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Position> query = criteriaBuilder.createQuery(Position.class);
        Root<Position> from = query.from(Position.class);

        return em.createQuery(query.select(from)
                .where(criteriaBuilder.like(from.get("name"),"%"+name+"%")))
                .getResultList();
    }

    @Override
    public Position findById(Long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Position> query = criteriaBuilder.createQuery(Position.class);
        Root<Position> from = query.from(Position.class);

        return em.createQuery(
                query.select(from)
                    .where(criteriaBuilder.equal(from.get("id"),id)))
                .getSingleResult();
    }

    @Override
    @Transactional
    public Position create(Position obj) {
        em.persist(obj); // dodawanie obiektu
        return obj;
    }

    @Override
    @Transactional
    public Position update(Position obj) {
        return em.merge(obj);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        em.createQuery("DELETE FROM Position WHERE id =:id")
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Position obj) {
        em.remove(obj);
    }
}
