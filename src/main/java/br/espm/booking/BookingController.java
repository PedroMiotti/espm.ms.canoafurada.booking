package br.espm.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    public BookingDto bookCabin(BookingDto bookingInfo){
        return bookingService.bookCabin(bookingInfo);
    }
}
