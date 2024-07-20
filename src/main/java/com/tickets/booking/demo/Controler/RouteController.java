package com.tickets.booking.demo.Controler;

import com.tickets.booking.demo.Model.Route;
import com.tickets.booking.demo.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route savedRoute = routeService.createRoute(route);
        return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Optional<Route> route = routeService.getRouteById(id);
        return route.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return new ResponseEntity<>("Route deleted successfully", HttpStatus.OK);
    }

    // Additional controller mappings as needed
}
