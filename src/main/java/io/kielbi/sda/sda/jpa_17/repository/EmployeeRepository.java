package io.kielbi.sda.sda.jpa_17.repository;

import io.kielbi.sda.sda.jpa_17.entity.Employee;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository

public class EmployeeRepository extends AbstractCustomCrudRepository<Employee, Long> {

    public EmployeeRepository(EntityManager em) {
        super(em, Employee.class);
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery(
                "FROM Employee e " +
                        "LEFT JOIN FETCH e.position" +
                        " LEFT JOIN FETCH e.project")
                .getResultList();
    }

    @Override
    public Employee findById(Long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = query.from(Employee.class);
        from.fetch("position", JoinType.LEFT);
        from.fetch("project", JoinType.LEFT);

        Employee employee = em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get("id"), id)))
                .getSingleResult();
        //hibernatem dociagnie selectem liste equipments
        Hibernate.initialize(employee.getEquipments());
        Hibernate.initialize(employee.getSkills());

        return employee;
    }
}
