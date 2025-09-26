package com.example.dumpdbproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "aircrafts", schema = "bookings")
public class Aircraft {

    @Id
    @Column(name = "aircraft_code", unique = true, nullable = false, length = 3)
    private String aircraftCode;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer range;

    @OneToMany(mappedBy = "aircraft")
    private Set<Flight> flights = new HashSet<>();

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Seat> seats = new HashSet<>();
}
