package at.etc;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public User save(User user) {
       return user;
    }
}
