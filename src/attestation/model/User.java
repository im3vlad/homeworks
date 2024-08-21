package attestation.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class User {
    UUID id;
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    String login;
    String password;
    String confirmPassword;
    String lastName;
    String firstName;
    String patronymic;
    int age;
    boolean isWorker = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.length() > 20) {
            throw new IllegalArgumentException("Логин должен содержать не более 20 символов.");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() > 20) {
            throw new IllegalArgumentException("Пароль должен содержать не более 20 символов.");
        }
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (confirmPassword.length() > 20) {
            throw new IllegalArgumentException("Пароль должен содержать не более 20 символов.");
        }
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
        return id + "|" + dateTime + "|"
                 + login + "|" + password + "|" + confirmPassword + "|" +
                 lastName + "|" +
                firstName + "|" +
                 patronymic + "|" +
                 age + "|" +isWorker +
                "|";
    }
}
