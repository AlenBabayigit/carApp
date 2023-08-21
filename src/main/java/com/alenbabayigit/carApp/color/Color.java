package com.alenbabayigit.carApp.color;

import jakarta.persistence.*;
import lombok.*;

@Entity  // Java Persistence API -> Creates a table
@Table(name = "colors") // Java Persistence API -> Creates a table
@Data  // Lombok -> Generates toString(), equals(), hashCode(), getter and setter, and required args constructor methods all combined.
/*
@Getter              // Lombok -> Generates accessor methods.
@Setter              // Lombok -> Generates mutator methods.
@NoArgsConstructor   // Lombok -> Generates no args constructor method.
@AllArgsConstructor  // Lombok -> Generates all args constructor method.
*/
public class Color {

    @Id  // JPA -> Indicates the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA -> Automatically generates the primary key.
    @Column(name = "id")
    private Integer id;


    @Column(name = "name", nullable = false, unique = true)  // JPA ->
    private String name;

}

