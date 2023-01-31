package at.etc.employees.bdd;

import java.io.IOException;

import at.etc.employees.EmployeesApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(classes = EmployeesApplication.class)
public class SpringIntegrationTest {

    static ResponseEntity<String> responseEntity = null;

    protected RestTemplate restTemplate = new RestTemplate();

    void executeGet(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        responseEntity = restTemplate.getForEntity(url, String.class);
    }
}
