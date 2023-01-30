package at.etc;

import com.tngtech.jgiven.Stage;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    public WhenSomeAction some_action() {
        return self();
    }
}
