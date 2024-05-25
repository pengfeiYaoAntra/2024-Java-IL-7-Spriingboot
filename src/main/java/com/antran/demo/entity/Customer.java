package com.antran.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;

    @Column(name = "age")
    private int age;
    @Column(name = "country")
    private String country;

}
