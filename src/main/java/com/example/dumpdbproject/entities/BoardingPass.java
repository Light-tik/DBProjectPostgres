package com.example.dumpdbproject.entities;


import com.example.dumpdbproject.entities.id.BoardingPassId;
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
@Table(name = "boarding_passes", schema = "bookings")
public class BoardingPass {

    @EmbeddedId
    private BoardingPassId id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no", insertable = false, updatable = false),
            @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", insertable = false, updatable = false)
    })
    private TicketFlight ticketFlight;

    @Column(name = "boarding_no", nullable = false)
    private  Integer boardingNo;

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;
}
