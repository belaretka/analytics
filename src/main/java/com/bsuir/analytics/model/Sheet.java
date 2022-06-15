package com.bsuir.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "sheets")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;
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

    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name = "companies_id_company", referencedColumnName = "id")
    private Company company;

    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn (name = "companies_users_id_user", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sheet", cascade = CascadeType.ALL)
    private List<Ratio> ratios;


    public String getCompanyName() {
        return this.company.getName();
    }

}
