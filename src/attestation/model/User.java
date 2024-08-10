package attestation.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    UUID id = UUID.randomUUID();
    LocalDateTime dateTime = LocalDateTime.now();
    String login;
    String password;
    String confirmPassword;
    String lastName;
    String firstName;
    String patronymic;
    int age;
    boolean isWorker = false;

    public User(UUID id, String login, String password,
                String confirmPassword, String lastName,
                String firstName, String patronymic, int age, boolean isWorker) {
        this.id = id;
        if (login.length() > 20 || password.length() > 20 || confirmPassword.length() > 20) {
            throw new IllegalArgumentException("Максимум 20 символов.");
        }
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
        this.isWorker = isWorker;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(dateTime, user.dateTime) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName) && Objects.equals(patronymic, user.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, login, password, confirmPassword, lastName, firstName, patronymic, age, isWorker);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }
}
