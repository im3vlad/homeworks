package homework12;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class Person {
    private String lastName;
    private String name;
    private String patromynic;
    private Date dateOfBirthday;
    private Long numberPhone;
    private String sex;
    private Integer age;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new RuntimeException("Фамилия не может быть пустой строкой.");
        } else if (!Pattern.matches("[а-яА-Я\s]+", lastName)) {
            throw new RuntimeException("Фамилия должна содержать только буквы русского алфавита.");
        } else if (lastName.length() <= 2) {
            throw new RuntimeException("Фамилия должна быть больше двух символов.");
        } else {
            this.lastName = lastName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Имя не может быть пустой строкой.");
        } else if (!Pattern.matches("[а-яА-Я\s]+", name)) {
            throw new RuntimeException("Имя должно содержать только буквы русского алфавита.");
        } else if (name.length() <= 2) {
            throw new RuntimeException("Имя должно быть больше двух символов.");
        } else {
            this.name = name;
        }
    }

    public String getPatromynic() {
        return patromynic;
    }

    public void setPatromynic(String patromynic) {
        if (patromynic == null || patromynic.isEmpty()) {
            throw new RuntimeException("Отчество не может быть пустой строкой.");
        } else if (!Pattern.matches("[а-яА-Я\s]+", patromynic)) {
            throw new RuntimeException("Отчество должно содержать только буквы русского алфавита.");
        } else if (patromynic.length() <= 2) {
            throw new RuntimeException("Отчество должно быть больше двух символов.");
        } else {
            this.patromynic = patromynic;
        }
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) throws DataFormatException {
        if (dateOfBirthday == null) {
            throw new DataFormatException("Укажите дату рождения в формате dd.mm.yyyy");
        }
        this.dateOfBirthday = dateOfBirthday;
    }



    public Long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(Long numberPhone) {
        if (numberPhone == null || numberPhone == 0){
            throw new RuntimeException("Номер телефона должен быть.");
        }else if(Long.toString(numberPhone).length() < 11){
            throw new RuntimeException("Номер телефона должен состоять из 11 цифр.");
        } else
            this.numberPhone = numberPhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex == null || sex.isEmpty()){
            throw new RuntimeException("Пол не может быть пустым");
        } else if (!Pattern.matches("[fm]+", sex)) {
            throw new RuntimeException("Пол должен содержать символы f или m");
        } else if (sex.length() > 1){
            throw new RuntimeException("Пол должен содержать один символ");
        }
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age < 1 && age > 100){
            throw new RuntimeException("Возраст не может быть отрицательным числом.");
        } else if (age > 100) {
            throw new RuntimeException("Возраст должен быть меньше 100.");
        }
        this.age = age;
    }

    public Person(){

    }
    public Person(String lastName, String name, String patromynic, Date dateOfBirthday, Long numberPhone, String sex, Integer age) throws DataFormatException {
        this.setLastName(lastName);
        this.setName(name);
        this.setPatromynic(patromynic);
        this.setDateOfBirthday(dateOfBirthday);
        this.setNumberPhone(numberPhone);
        this.setSex(sex);
        this.setAge(age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getName(), person.getName()) && Objects.equals(getPatromynic(), person.getPatromynic()) && Objects.equals(getDateOfBirthday(), person.getDateOfBirthday()) && Objects.equals(getNumberPhone(), person.getNumberPhone()) && Objects.equals(getSex(), person.getSex()) && Objects.equals(getAge(), person.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getName(), getPatromynic(), getDateOfBirthday(), getNumberPhone(), getSex(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patromynic='" + patromynic + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", numberPhone=" + numberPhone +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
