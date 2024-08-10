package attestation.repositories;

import attestation.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersRepositoryFileImpl implements UsersRepository {

    @Override
    public void createUser(User user) {
       user = new User(UUID.randomUUID(), "bingo_45", "45r45",
                "45r45", "Андропов", "Владислав", "Борисович",
                36, true);
       User user1 = new User(UUID.randomUUID(),"bongo46","46t46","46t46",
               "Козельский","Андрей","Александрович",23,false);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        try (PrintWriter writer = new PrintWriter(new FileWriter("file.txt", true))) {

            for (User item : users) {
                writer.println(item);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
