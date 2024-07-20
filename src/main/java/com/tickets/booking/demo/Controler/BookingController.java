package com.tickets.booking.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tickets.booking.demo.Model.BookingTicket;
import com.tickets.booking.demo.Repository.BookingTicketRepository;

import java.util.List;

@RestController
@RequestMapping("/api/BookingTtickets")
public class BookingController {
    @Autowired
    private BookingTicketRepository bookingRepository;

    @GetMapping
    public List<BookingTicket> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public BookingTicket createBooking(@RequestBody BookingTicket booking) {
        return bookingRepository.save(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}
