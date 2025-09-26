package com.example.dumpdbproject.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights_v", schema = "bookings")
@Immutable
public class FlightView {
    @Id
    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "flight_no")
    private String flightNo;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "departure_airport_name")
    private String departureAirportName;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "arrival_airport_name")
    private String arrivalAirportName;

    @Column(name = "arrival_city")
    private String arrivalCity;

    @Column(name = "scheduled_departure_local")
    private LocalDateTime scheduledDepartureLocal;

    @Column(name = "actual_departure_local")
    private LocalDateTime actualDepartureLocal;

    @Column(name = "scheduled_duration")
    private Duration scheduledDuration;

    @Column(name = "actual_duration")
    private Duration actualDuration;
}
