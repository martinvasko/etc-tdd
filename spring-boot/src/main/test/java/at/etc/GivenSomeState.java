package at.etc;

import com.tngtech.jgiven.Stage;

public class GivenSomeState extends Stage<GivenSomeState> {
    public GivenSomeState some_state() {
        return self();
    }

    public GivenSomeState email_get_configuration(Client client) {
        return self();
    }

    public GivenSomeState smpt_server_is_available() {
        return self();
    }

    public GivenSomeState email_has_recipient(Client client) {
        return self();
    }

    public GivenSomeState email_contains_attachment(Client client) {
        return self();
    }

    public GivenSomeState email_is_composed(Client client) {
        return self();
    }
}
