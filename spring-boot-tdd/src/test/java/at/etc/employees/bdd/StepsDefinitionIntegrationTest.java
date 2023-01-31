package at.etc.employees.bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepsDefinitionIntegrationTest extends SpringIntegrationTest {
    @When("the client calls /employee")
    public void the_client_issues_GET_employees() throws Throwable {
        executeGet("http://localhost:8080/employee");
    }

    @Then("the client receives status code of 200")
    public void the_client_receives_status_code_of() throws Throwable {
        final HttpStatus currentStatusCode = responseEntity.getStatusCode();
        assertThat("status code is correct : " + currentStatusCode, currentStatusCode, is(HttpStatus.OK));
    }

    @And("the client receives an array of employees")
    public void the_client_receives_list_of_employees() throws Throwable {
        assertThat(responseEntity.getBody(), is("[]"));
    }
}
