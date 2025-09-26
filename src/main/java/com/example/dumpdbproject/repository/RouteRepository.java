package com.example.dumpdbproject.repository;

import com.example.dumpdbproject.entities.Flight;
import com.example.dumpdbproject.view.RouteView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT * FROM bookings.routes", nativeQuery = true)
    List<RouteView> findAllRoutes();
}
