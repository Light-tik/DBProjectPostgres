package com.example.dumpdbproject.view;

public interface RouteView {
    String getFlightNo();
    String getDepartureAirport();
    String getDepartureAirportName();
    String getDepartureCity();
    String getArrivalAirport();
    String getArrivalAirportName();
    String getArrivalCity();
    String getAircraftCode();
    Object getDuration();
    Integer[] getDaysOfWeek();
}
