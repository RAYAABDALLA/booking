package com.tickets.booking.demo.Repository;

import com.tickets.booking.demo.Model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
