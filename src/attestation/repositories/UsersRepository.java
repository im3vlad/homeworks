package attestation.repositories;

import attestation.model.User;

import java.util.List;
import java.util.UUID;

public interface UsersRepository {
    void createUser(UUID id, String login, String password, String confirmPassword,
                    String lastName, String firstName, String patronymic, int age, boolean isWorker);
    User   findById(String  id);
    List<User> findAll();
    void  update(User user);
    void   deleteById(String   id);
    void deleteAll();
}
