package at.etc.employees.dao;


import at.etc.employees.dao.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import at.etc.employees.model.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Steve", "Jobs");

    employeeRepository.save(employee);

    Iterable<Employee> employees = employeeRepository.findAll();
    Assertions.assertThat(employees).extracting(Employee::getFirstName).containsOnly("Steve");

    employeeRepository.deleteAll();
    Assertions.assertThat(employeeRepository.findAll()).isEmpty();
  }
}
