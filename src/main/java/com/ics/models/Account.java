package com.ics.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
@Table(name="account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;


    @Column(nullable = false, length = 8, unique = true)
    private String fps;


    @Column(nullable = false)
    private Long balance;


}
