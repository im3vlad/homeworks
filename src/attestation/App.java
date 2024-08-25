package attestation;

import attestation.model.User;
import attestation.repositories.UsersRepositoryFileImpl;

import java.util.List;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        UsersRepositoryFileImpl repositoryFile = new UsersRepositoryFileImpl();
       UUID userId = UUID.randomUUID();
        repositoryFile.createUser(userId, "bingo_45", "45r45",
                "45r45", "Андропов", "Владислав", "Борисович",
                36, true);
        UUID userId2 = UUID.randomUUID();
        repositoryFile.createUser(userId2, "bongo46","46t46","46t46",
                "Козельский","Андрей","Александрович",23,false);
        //User user = repositoryFile.findById(userId2.toString());

        /* User user = new User();
        user.setId(UUID.fromString("908aaa63-9f92-4fa5-abb1-e5e3a6506ba7"));
        user.setLogin("bk");
        user.setPassword("123b");
        user.setConfirmPassword("123b");
        user.setLastName("bobrov");
        user.setFirstName("andrey");
        user.setPatronymic("andreich");
        user.setAge(12);
        user.setWorker(true);
*/
        //List<User> users = repositoryFile.findAll();
       // repositoryFile.findAll();
        //repositoryFile.deleteAll();
       //repositoryFile.update(user);
        //repositoryFile.findById("39606784-e45f-4f2c-8272-d0818edafa77");
        System.out.println("УРА");
    }


}
