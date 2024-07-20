package com.tickets.booking.demo.Services;

import com.tickets.booking.demo.Model.Route;
import com.tickets.booking.demo.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    // Additional service methods as needed
}
