package com.tickets.booking.demo.Controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tickets.booking.demo.Model.Bus;
import com.tickets.booking.demo.Services.BusService;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping
    public Bus createBus(@RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @GetMapping
    public List<Bus> getAllBus() {
        return busService.getAllBus();
    }

    @GetMapping("/{id}")
    public Optional<Bus> getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable("id") Long busId) {
        busService.deleteBus(busId);
        return new ResponseEntity<>("Bus has been deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        return busService.updateBus(id, bus);
    }
}
