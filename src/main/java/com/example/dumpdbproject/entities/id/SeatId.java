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
public class SeatId implements Serializable {
    @Column(name = "aircraft_code", length = 3)
    private String aircraftCode;

    @Column(name = "seat_no", length = 4)
    private String seatNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatId)) return false;
        SeatId that = (SeatId) o;
        return Objects.equals(aircraftCode, that.aircraftCode) &&
                Objects.equals(seatNo, that.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftCode, seatNo);
    }
}
