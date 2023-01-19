package com.example.primuskartebackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Longdrinks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String alcohol;

    @Column(nullable = false)
    private String softdrink;

    @Column(nullable = false)
    private Double alcoholamount;

    @Column(nullable = false)
    private Double softdrinkamount;

    @Column(nullable = false)
    private Double price;

}
