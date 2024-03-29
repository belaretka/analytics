package com.bsuir.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ratios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ratio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name ="name")
    private String name;

    @Column (name = "value")
    private double value;

    @ManyToOne
    @JoinColumn (name = "sheets_id_sheet", referencedColumnName = "id")
    private Sheet sheet;

}

