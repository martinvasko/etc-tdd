package at.etc.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import at.etc.employees.controllers.EmployeeController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeesApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Test
	public void contextLoads() {
		assertThat(employeeController).isNotNull();
	}
}
