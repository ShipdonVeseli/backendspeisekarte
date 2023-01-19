package com.example.primuskartebackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aktion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String flaschename;

    @Column(nullable = false)
    private String flascheamount;

    @Column(nullable = false)
    private String beigetrank;

    @Column(nullable = false)
    private Double shishaamount;

    @Column(nullable = false)
    private Double price;

}
