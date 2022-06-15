package com.bsuir.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name = "company_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private String type;

    @Transient
    private String username;
    @Transient
    private long id_user;

    @ManyToOne
    @JoinColumn(name = "users_id_user", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private List<Case> cases;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private List<Sheet> sheets;

    public User getUser() {
        return user;
    }

    public void setUserId (long id) {
        this.user.setId(id);
    }

    public long getId_user(long id) {
        return id_user;
    }
}
