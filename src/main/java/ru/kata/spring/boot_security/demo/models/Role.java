package ru.kata.spring.boot_security.demo.models;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", unique = true)
    @Size(min = 2, message = "Минимальное название роли должно содержать от 2 символов")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
