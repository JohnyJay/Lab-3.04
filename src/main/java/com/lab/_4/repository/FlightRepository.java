package com.lab._4.repository;

import com.lab._4.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findAllByAircraftContaining(String str);
    List<Flight> findAllByFlightMileageGreaterThan(int distance);
}
