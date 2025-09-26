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
@Table(name = "airports", schema = "bookings")
public class Airport {

    @Id
    @Column(name = "airport_code", unique = true, nullable = false, length = 3)
    private String airportCode;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private String timezone;

    @OneToMany(mappedBy = "departureAirport")
    private Set<Flight> departures = new HashSet<>();

    @OneToMany(mappedBy = "arrivalAirport")
    private Set<Flight> arrivals = new HashSet<>();
}
