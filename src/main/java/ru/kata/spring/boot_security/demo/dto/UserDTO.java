package ru.kata.spring.boot_security.demo.dto;



import ru.kata.spring.boot_security.demo.models.Role;

import javax.validation.constraints.*;
import java.util.List;

public class UserDTO {

    @Size(min = 2, message = "Минимальное значение username от 2 символов")
    @NotEmpty(message = "Username не должен быть пустым")
    private String username;

    @Size(min = 5, message = "Минимальное название фамилии должно начинаться от 2 символов")
    private String lastname;

    @NotNull
    @Min(value = 1, message = "Возраст должен быть больше нуля")
    @Max(value = 120, message = "Возраст не может быть больше 120")
    private int age;

    @Size(min = 5, message = "Минимальное название почты должно начинаться от 5 символов")
    private String email;

    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;

    @NotEmpty(message = "Необходимо выбрать роль пользователя")
    List<Role> roles;

    public UserDTO() {
    }

    public UserDTO(String username, String lastname, int age, String email, String password, List<Role> roles) {
        this.username = username;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
