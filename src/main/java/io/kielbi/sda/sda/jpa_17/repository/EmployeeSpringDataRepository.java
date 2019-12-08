package io.kielbi.sda.sda.jpa_17.repository;

import io.kielbi.sda.sda.jpa_17.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeSpringDataRepository extends JpaRepository<Employee, Long> {

}
