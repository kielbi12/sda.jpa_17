package io.kielbi.sda.sda.jpa_17.repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractCustomCrudRepository<T, ID> implements CustomCrudRepository<T, ID> {

    protected EntityManager em;
    private Class<T> clazz;

    public AbstractCustomCrudRepository(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }


    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);

        return em.createQuery(query.select(from)).getResultList();
    }

    public List<String> findAllNames() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Path<String> name = query.from(clazz).get("name");

        return em.createQuery(query.select(name)).getResultList();
    }

    @Override
    public T findById(ID id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);

        return em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get("id"), id)))
                .getSingleResult();
    }

    @Override
    @Transactional
    public T create(T obj) {
        em.persist(obj); // dodawanie obiektu
        return obj;
    }

    @Override
    @Transactional
    public T update(T obj) {
        return em.merge(obj);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        em.createQuery("DELETE FROM " + clazz.getSimpleName() + " WHERE id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete(T obj) {
        em.remove(obj);
    }
}
