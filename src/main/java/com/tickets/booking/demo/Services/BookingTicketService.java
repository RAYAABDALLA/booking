package com.tickets.booking.demo.Services;

import com.tickets.booking.demo.Model.BookingTicket;
import com.tickets.booking.demo.Repository.BookingTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingTicketService {

    @Autowired
    private BookingTicketRepository bookingTicketRepository;

    public BookingTicket createBookingTicket(BookingTicket bookingTicket) {
        return bookingTicketRepository.save(bookingTicket);
    }

    public List<BookingTicket> getAllBookingTickets() {
        return bookingTicketRepository.findAll();
    }

    public BookingTicket getBookingTicketById(Long bookingTicketId) {
        Optional<BookingTicket> bookingTicket = bookingTicketRepository.findById(bookingTicketId);
        return bookingTicket.orElse(null);
    }

    public void deleteBookingTicket(Long bookingTicketId) {
        bookingTicketRepository.deleteById(bookingTicketId);
    }

    public BookingTicket updateBookingTicket(Long bookingTicketId, BookingTicket bookingTicket) {
        Optional<BookingTicket> existingBooking = bookingTicketRepository.findById(bookingTicketId);
        if (existingBooking.isPresent()) {
            BookingTicket updatedBooking = existingBooking.get();
            updatedBooking.setPassengerName(bookingTicket.getPassengerName());
            updatedBooking.setBusRoute(bookingTicket.getBusRoute());
            updatedBooking.setBookingDate(bookingTicket.getBookingDate());
            updatedBooking.setSeatNumber(bookingTicket.getSeatNumber());

            return bookingTicketRepository.save(updatedBooking);
        }
        return null;
    }
}
