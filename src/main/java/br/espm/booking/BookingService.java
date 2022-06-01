package br.espm.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDto bookCabin(BookingDto bookingInfo){

        return new BookingDto();
    }

}
