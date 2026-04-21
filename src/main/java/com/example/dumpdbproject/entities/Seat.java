package com.example.dumpdbproject.entities;

import com.example.dumpdbproject.entities.id.SeatId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "seats", schema = "bookings")
public class Seat {
    @EmbeddedId
    private SeatId id;

    @MapsId("aircraftCode")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraft;

    @Column(name = "fare_conditions", nullable = false)
    private  String fareConditions;
}
