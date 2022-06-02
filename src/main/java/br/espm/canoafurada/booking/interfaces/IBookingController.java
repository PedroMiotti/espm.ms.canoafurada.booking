package br.espm.canoafurada.booking.interfaces;

import br.espm.canoafurada.booking.BookingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBookingController {

    @PostMapping("/book")
    public BookingDto bookCabin(@RequestBody BookingDto bookingInfo);

    @GetMapping("/book")
    public List<BookingDto> getAllBookings();
}
