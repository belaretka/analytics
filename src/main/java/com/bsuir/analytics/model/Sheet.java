package com.bsuir.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sheets")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sheet;
    @Column (name = "period")
    private Date date;

    @Column(name = "fixed_assets")
    private double fixed_assets;
    @Column (name = "authorized_stock")
    private double authorized_stock;
    @Column (name = "reserve_capital")
    private double reserve_capital;
    @Column (name = "working_capital")
    private double working_capital;

    @Column (name = "long_term_assets")
    private double long_term_assets;
    @Column (name = "short_term_assets")
    private double short_term_assets;
    @Column (name = "total")
    private double total;
    @Column (name = "equity")
    private double equity;
    @Column (name = "long_liabilities")
    private double long_liabilities;
    @Column (name = "short_liabilities")
    private double short_liabilities;

    @ManyToOne
    @JoinColumn(name = "companies_id_company", referencedColumnName = "id_company")
    private Company company;

    @ManyToOne
    @JoinColumn (name = "companies_users_id_user", referencedColumnName = "id_user")
    private User user;

}
