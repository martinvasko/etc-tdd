package at.etc;

import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;

public class FirstScenarioTest  extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    @Test
    public void something_should_happen() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }

    @Test
    void scenario_sendSingleEmail() {
        Client client = new Client();
        // PreCondition
        given().email_get_configuration(client)
                .and().smpt_server_is_available()
                .and().email_has_recipient(client)
                .and().email_contains_attachment(client)
                .and().email_is_composed(client);

        // Invariant
        when().smpt_server_is_available()
                .and().send_email(client);

        //PostCondition
        then().email_is_arrived();
    }

}
