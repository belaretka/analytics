package com.bsuir.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_admin;

    @ManyToOne
    @JoinColumn(name = "users_id_user", referencedColumnName = "id_user")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return getId_admin() == admin.getId_admin() && getUser().equals(admin.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_admin(), getUser());
    }

}
