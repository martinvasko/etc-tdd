package at.etc;

import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SampleUnitTest {

    @Autowired
    private RegisterUseCase registerUseCase;

    @Test
    void savedUserHasRegistrationDate() {
        User user = new User("steve", "steve@apple.com");
        User savedUser = registerUseCase.registerUser(user);
        assertThat(savedUser.getRegistrationDate()).isNotNull();
    }

}

