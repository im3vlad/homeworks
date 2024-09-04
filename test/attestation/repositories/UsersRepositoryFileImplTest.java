package attestation.repositories;

import attestation.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {

    private UsersRepositoryFileImpl usersRepository = new UsersRepositoryFileImpl();
    @Test
    void createUserDublicateId() {
        //негативный
        assertThrows(RuntimeException.class, () ->{
            usersRepository.createUser(UUID.fromString("808aaa63-9f92-4fa5-abb1-e5e3a6506ba0"), "yu", "56y",
                    "46y","df","ty","ui",14,false);
        }
        );
    }
    @Test
    void createUserDublicateLogin(){
        assertThrows(RuntimeException.class, () ->{
            usersRepository.createUser(UUID.randomUUID(),"bk", "567n","567n","Petrov","Anton",
                    "Anton",14,false);
        });
    }

    @Test
    void createUserWithInvalidPassword() {
        //негативный
        assertThrows(IllegalArgumentException.class, () -> {
            usersRepository.createUser(UUID.randomUUID(), "bongo46","46t46".repeat(10),"46t46".repeat(10),
                    "Козельский","Андрей","Александрович",23,false);
        }, "Пароль должен содержать не более 20 символов.");
    }

    @Test
    void updateFileWithoutUser() {
        //позитивный
        usersRepository.deleteById("908aaa63-9f92-4fa5-abb1-e5e3a6506ba7");
        User user = new User();
        user.setId(UUID.fromString("908aaa63-9f92-4fa5-abb1-e5e3a6506ba7"));
        user.setLogin("bk");
        user.setPassword("123b");
        user.setConfirmPassword("123b");
        user.setLastName("bobrov");
        user.setFirstName("andrey");
        user.setPatronymic("andreich");
        user.setAge(12);
        user.setWorker(true);
        usersRepository.update(user);
        List<User> actualUsers = usersRepository.findAll();
        assertTrue(actualUsers.contains(user));
    }

    @Test
    void updateFileWithUser() {
        //позитивный
        usersRepository.createUser(UUID.fromString("808aaa63-9f92-4fa5-abb1-e5e3a6506ba0"), "gt","435j","435j",
                "pop","ank","pops",34,true);
        User user = new User();
        user.setId(UUID.fromString("808aaa63-9f92-4fa5-abb1-e5e3a6506ba0"));
        user.setLogin("bk");
        user.setPassword("123b");
        user.setConfirmPassword("123b");
        user.setLastName("bobrov");
        user.setFirstName("andrey");
        user.setPatronymic("andreich");
        user.setAge(12);
        user.setWorker(true);
        usersRepository.update(user);
        List<User> actualUsers = usersRepository.findAll();
        assertTrue(actualUsers.contains(user));
    }

}