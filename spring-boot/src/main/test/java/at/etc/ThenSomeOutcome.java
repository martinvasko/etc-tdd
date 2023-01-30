package at.etc;

import com.tngtech.jgiven.Stage;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
    public ThenSomeOutcome some_outcome() {
        return self();
    }

    public ThenSomeOutcome email_is_arrived() {
        return self();
    }
}
