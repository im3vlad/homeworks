package attestation.repositories;

import attestation.model.User;

import java.util.List;

public interface UsersRepository {
    void createUser(User user);
    User   findById(String  id);
    List<User> findAll();
    void  update(User user);
    void   deleteById(String   id);
    void deleteAll();
}
