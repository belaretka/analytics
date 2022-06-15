package com.bsuir.analytics.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicUpdate
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column (name = "role")
    private String role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Company> companies;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getStringRole() {
        if (role.equals("ROLE_USER"))
            return "Пользователь";
        else if (role.equals("ROLE_ADMIN"))
            return "Администратор";
        return role;
    }
}
