package br.espm.canoafurada.booking;

import br.espm.canoafurada.booking.interfaces.IBookingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController implements IBookingController {

    @Autowired
    public BookingService bookingService;

    @Override
    public BookingDto bookCabin(BookingDto bookingInfo) {
        return bookingService.bookCabin(bookingInfo);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
