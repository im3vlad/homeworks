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
        List<User> users = repositoryFile.findAll();
        System.out.println(users);
    }


}
