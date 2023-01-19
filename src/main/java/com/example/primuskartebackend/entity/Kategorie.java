package com.example.primuskartebackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String link;

    @Column(columnDefinition = "LONGTEXT")
    private String photo;

    @Column(nullable = false)
    private String name;

}
