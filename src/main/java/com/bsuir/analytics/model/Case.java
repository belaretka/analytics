package com.bsuir.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cases")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name = "period")
    private Date period;

    @Column(name = "result")
    private String result;

    @ManyToOne
    @JoinColumn(name = "companies_id_company", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "companies_users_id_user", referencedColumnName = "id")
    private User user;
}
