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
    private long id_case;

    @Column(name = "period")
    private Date period;

    @Column(name = "result")
    private String result;

    @ManyToOne
    @JoinColumn(name = "companies_id_company", referencedColumnName = "id_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "companies_users_id_user", referencedColumnName = "id_user")
    private User user;
}
