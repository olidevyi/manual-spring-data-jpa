package com.olidev.pe.manualspringdatajpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence", // Cualquier nombre
            sequenceName = "client_sequence", // Cualquier nombre
            initialValue = 1, // valor inicial
            allocationSize = 1 // Aumenta de 1 en 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;

    private String name;
    private Integer active;
    private Timestamp createAt;
    private String password;

    @Column(name = "email", length = 100, nullable = false)
    private String email;
}
