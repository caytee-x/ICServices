package com.ics.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(nullable = false, length = 64)
    private String password;




}
