package at.etc.employees.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import at.etc.employees.model.Employee;
import at.etc.employees.services.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class StandaloneControllerTests {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testfindAll() throws Exception {
        Employee employee = new Employee("Steve", "Jobs");
        List<Employee> employees = Arrays.asList(employee);

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Steve")));
    }

    @Test
    public void whenValidInput_thenReturns200() throws Exception {
        Employee employee = new Employee("Steve", "Jobs");

        mockMvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());
    }

    @Test
    public void whenNullValue_thenReturns200() throws Exception {
        Employee employee = new Employee("Steve", null);

        mockMvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());
    }

    @Test
    public void whenValidInput_thenMapsToBusinessModel() throws Exception {
        Employee employee = new Employee("Steve", "Jobs");

        mockMvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());

        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeService, times(1)).save(employeeCaptor.capture());
        assertThat(employeeCaptor.getValue().getFirstName()).isEqualTo("Steve");
        assertThat(employeeCaptor.getValue().getLastName()).isEqualTo("Jobs");
    }
}
