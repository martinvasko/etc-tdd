package at.etc;

import java.time.LocalDateTime;
import java.util.Date;

public class User {

    LocalDateTime time;

    public User(String userName, String email) {

    }

    public LocalDateTime getRegistrationDate() {
        return time;
    }

    public void setRegistrationDate(LocalDateTime time) {
        this.time = time;
    }
}
