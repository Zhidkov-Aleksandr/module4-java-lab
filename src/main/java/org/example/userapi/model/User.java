package org.example.userapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")          // именно такое имя, как в задании
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    public User(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.role      = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;
}
