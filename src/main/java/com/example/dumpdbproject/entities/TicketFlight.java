package com.example.dumpdbproject.entities;

import com.example.dumpdbproject.entities.id.TicketFlightId;
import com.example.dumpdbproject.enums.FareConditions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket_flights", schema = "bookings")
public class TicketFlight {
    @EmbeddedId
    private TicketFlightId id;

    @MapsId("ticketNo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_no", nullable = false)
    private Ticket ticket;

    @MapsId("flightId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Enumerated(EnumType.STRING)
    @Column(name = "fare_conditions", nullable = false, length = 10)
    private FareConditions fareConditions;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @OneToOne(mappedBy = "ticketFlight")
    private BoardingPass boardingPass;
}
