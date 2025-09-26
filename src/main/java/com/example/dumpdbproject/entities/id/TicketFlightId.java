package com.example.dumpdbproject.entities.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketFlightId implements Serializable {
    @Column(name = "ticket_no", length = 13)
    private String ticketNo;

    @Column(name = "flight_id")
    private Integer flightId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketFlightId)) return false;
        TicketFlightId that = (TicketFlightId) o;
        return Objects.equals(flightId, that.flightId) &&
                Objects.equals(ticketNo, that.ticketNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, ticketNo);
    }
}
