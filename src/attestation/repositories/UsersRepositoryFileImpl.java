package attestation.repositories;

import attestation.model.User;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UsersRepositoryFileImpl implements UsersRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void createUser(UUID id, String login, String password, String confirmPassword,
                           String lastName, String firstName, String patronymic, int age, boolean isWorker) {

        users = findAll();
        users.forEach(user -> {
            if(id.equals(user.getId())) {
                throw new RuntimeException(id + " уже существует");
            }
            if (login.equals(user.getLogin())) {
                throw new RuntimeException(login + "уже существует");
            }
        });
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
        users.add(user);
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt", true))) {

            writer.println(user);

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    @Override
    public User findById(String id) {
        users.clear();
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
        users.clear();
        Scanner scanner = null;
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
        users.clear();
        users = findAll();
        
        Map<UUID, User> userMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));

        if (userMap.containsKey(user.getId())) {
            User userFromMap = userMap.get(user.getId());
            userFromMap.setWorker(user.isWorker());
            userFromMap.setLogin(user.getLogin());
            userFromMap.setAge(user.getAge());
            userFromMap.setFirstName(user.getFirstName());
            userFromMap.setLastName(user.getLastName());
            userFromMap.setConfirmPassword(user.getConfirmPassword());
            userFromMap.setPassword(user.getPassword());
            userFromMap.setPatronymic(user.getPatronymic());
            userFromMap.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        } else {
            userMap.put(user.getId(), user);
        }
        List<User> actualUsers = new ArrayList<>(userMap.values());
            deleteAll();
        writeUser(actualUsers);


    }

    @Override
    public void deleteById(String id) {
        users.clear();
        users = findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("В файле нет пользователей");
        }
        List<UUID> userIds = users.stream().map(user -> user.getId()).collect(Collectors.toUnmodifiableList());
        UUID idToDelete = UUID.fromString(id);
        if (userIds.contains(idToDelete)) {
            List<User> actualUsers = users.stream()
                    .filter(user -> !user.getId().equals(idToDelete)).collect(Collectors.toUnmodifiableList());
            deleteAll();
            writeUser(actualUsers);
        }
    }


    @Override
    public void deleteAll() {
        users.clear();
        users = findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("В файле нет пользователей");
        }
        users.clear();
        writeUser(users);

    }

    public void mapUser(String[] parts, User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String localDateTime = LocalDateTime.parse(parts[1], formatter).format(DateTimeFormatter.ISO_DATE_TIME);

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

    private static void writeUser(List<User> users) {
        try(PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Anastas\\IdeaProjects\\game\\src\\attestation\\resources\\attestation.txt"))) {
            for (User userUpdate  : users) {
                writer.println(userUpdate);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
}
