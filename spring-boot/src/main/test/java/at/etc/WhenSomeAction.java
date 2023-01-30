package at.etc;

import com.tngtech.jgiven.Stage;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    public WhenSomeAction some_action() {
        return self();
    }

    public WhenSomeAction smpt_server_is_available() {
        return self();
    }

    public WhenSomeAction send_email(Client client) {
        return self();
    }
}
