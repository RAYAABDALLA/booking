package com.tickets.booking.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickets.booking.demo.Model.Bus;
import com.tickets.booking.demo.Repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepo;

    public Bus createBus(Bus bus) {
        return busRepo.save(bus);
    }

    public List<Bus> getAllBus() {
        return busRepo.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busRepo.findById(id);
    }

    public void deleteBus(Long busId) {
        busRepo.deleteById(busId);
    }

    public Bus updateBus(Long busId, Bus bus) {
        bus.setBusId(busId);
        return busRepo.save(bus);
    }
}
