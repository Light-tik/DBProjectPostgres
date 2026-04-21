package com.example.dumpdbproject.entities;

import com.example.dumpdbproject.enums.StatusFlights;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "flights", schema = "bookings")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flights_seq")
    @SequenceGenerator(name = "flights_seq", sequenceName = "bookings.flights_flight_id_seq", allocationSize = 1)
    @Column(name = "flight_id")
    private Integer flightId;


    @Column(name = "flight_no",nullable = false, length = 6)
    private String flightNo;

    @Column(name = "scheduled_departure",nullable = false)
    private OffsetDateTime scheduledDeparture;

    @Column(name = "scheduled_arrival",nullable = false)
    private OffsetDateTime scheduledArrival;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "arrival_airport",nullable = false)
    private Airport arrivalAirport;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusFlights status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraft;

    @Column(name = "actual_departure")
    private OffsetDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private OffsetDateTime actualArrival;

    @OneToMany(mappedBy = "flight")
    private Set<TicketFlight> ticketFlights = new HashSet<>();
}
