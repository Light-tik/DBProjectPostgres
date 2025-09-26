package com.example.dumpdbproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tickets", schema = "bookings")
public class Ticket {

    @Id
    @Column(name = "ticket_no", unique = true, nullable = false, length = 13)
    private String ticketNo;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "book_ref", nullable = false)
    private Booking bookRef;

    @Column(name = "passenger_id", nullable = false, length = 20)
    private String passengerId;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "contact_data", columnDefinition = "jsonb")
    private String contactData;

    @OneToMany(mappedBy = "ticket")
    private Set<TicketFlight> ticketFlights = new HashSet<>();
}
