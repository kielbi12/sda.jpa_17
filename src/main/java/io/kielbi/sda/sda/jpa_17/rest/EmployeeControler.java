package io.kielbi.sda.sda.jpa_17.rest;

import io.kielbi.sda.sda.jpa_17.entity.Employee;
import io.kielbi.sda.sda.jpa_17.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")

public class EmployeeControler extends AbstractCustomController<Employee, Long> {

    public EmployeeControler(EmployeeRepository employeeRepository) {
        super(employeeRepository);
    }


}
