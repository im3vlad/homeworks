package attestation.repositories;

import attestation.model.User;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersRepositoryFileImpl implements UsersRepository {

    @Override
    public void createUser(UUID id, String login, String password, String confirmPassword,
                           String lastName, String firstName, String patronymic, int age, boolean isWorker) {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPatronymic(patronymic);
        user.setAge(age);
        user.setWorker(isWorker);
        List<User> users = new ArrayList<>();
        users.add(user);
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt", true))) {

            for (User item : users) {
                writer.println(item);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    @Override
    public User findById(String id) {
        Scanner scanner = null;
        User user = new User();
        try {
            scanner = new Scanner(new File("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts[0].equals(id)) {
                    mapUser(parts, user);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        Scanner scanner = null;
        List<User> users = new ArrayList<>();
        try {
            scanner = new Scanner(new File("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt"));
            while (scanner.hasNextLine()) {
                User user = new User();
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                mapUser(parts, user);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return users;
    }

    @Override
    public void update(User user) {


    }

    @Override
    public void deleteById(String id) {
        List<User> users = findAll();
        if (users.isEmpty()){
            throw new RuntimeException("В файле нет пользователей");
        }
        List<UUID> userIds = users.stream().map(user -> user.getId()).collect(Collectors.toUnmodifiableList());
        UUID idToDelete = UUID.fromString(id);
        if (userIds.contains(idToDelete)) {
            List<User> actualUsers = users.stream()
                    .filter(user -> !user.getId().equals(idToDelete)).collect(Collectors.toUnmodifiableList());
/*использовать метод deleteAll чтобы очистить файл
далее записать в пустой файл новую коллекцию user
 */
        deleteAll();
            try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt"))) {
                for (User user : users) {
                    writer.println(user);
                }
            } catch (IOException e) {
                System.out.println("Ошибка записи  " + e.getMessage());
            }
        }
    }



    @Override
    public void deleteAll() {
    List<User> users = findAll();
        if (users.isEmpty()){
            throw new RuntimeException("В файле нет пользователей");
        }
        users.clear();
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt"))) {
            for (User user : users) {
                writer.println(user.getId());
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи  " + e.getMessage());
        }

    }

    public void mapUser(String[] parts, User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        LocalDateTime localDateTime = LocalDateTime.parse(parts[1], formatter);

        user.setId(UUID.fromString(parts[0]));
        user.setDateTime(localDateTime);
        user.setLogin(parts[2]);
        user.setPassword(parts[3]);
        user.setConfirmPassword(parts[4]);
        user.setLastName(parts[5]);
        user.setFirstName(parts[6]);
        user.setPatronymic(parts[7]);
        user.setAge(Integer.valueOf(parts[8]));
        user.setWorker(Boolean.valueOf(parts[9]));
    }
}
