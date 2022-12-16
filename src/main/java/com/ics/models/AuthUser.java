package com.ics.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="AuthUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;

    @Column(nullable = false, length = 8, unique = true)
    private String fps;
    @Column(nullable = false, length = 30)
    private String first_name;
    @Column(nullable = false, length = 30)
    private String last_name;
    @Column(nullable = false)
    private Integer unit_num;
    @Column(nullable = false)
    private Integer cell_num;


}
