package br.espm.canoafurada.booking;

import br.espm.canoafurada.cabin.CabinDto;
import br.espm.canoafurada.cabin.ICabinController;
import br.espm.canoafurada.user.IUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ICabinController cabinController;

    @Autowired
    private IUserController userController;

    public BookingDto bookCabin(BookingDto bookingInfo){
        if(bookingInfo.getIdUser() == null ) return null;

        var existingCabins = cabinController.getAllCabins();
        var existingUser = userController.getUserById(UUID.fromString(bookingInfo.getIdUser()));

        if(existingCabins.isEmpty()) return null; // No cabins available
        if(existingUser == null) return null; // User does not exists

        var cabinsThatMatchTotalTravelers = existingCabins.stream()
                .filter(cabin -> cabin.getMaxPeople() >= bookingInfo.getTotalTravelers())
                .collect(Collectors.toList());

        var reservedCabinsOnReservedDate = bookingRepository.findAllByReserverdDate(bookingInfo.getReservedDate());

        var availableMatchingCabins = new ArrayList<CabinDto>();

        if(!reservedCabinsOnReservedDate.isEmpty()){
            for(var booking : reservedCabinsOnReservedDate){
                for(var cabin : cabinsThatMatchTotalTravelers ){
                    if(!(cabin.getId().compareTo(UUID.fromString(booking.getIdCabin())) == 0)
                            && !(availableMatchingCabins.stream().anyMatch(c -> c.getId() == cabin.getId())))
                        availableMatchingCabins.add(cabin);
                }
            }
        } else{
            for(var cabin : cabinsThatMatchTotalTravelers){
                availableMatchingCabins.add(cabin);
            }
        }

        if(availableMatchingCabins.isEmpty()) return null;

        CabinDto cabinMatch = availableMatchingCabins.stream().min(Comparator.comparing(cabin -> cabin.getMaxPeople())).get();

        var bookingToSave = new BookingEntity();
        bookingToSave.setIdUser(String.valueOf(existingUser.getId()));
        bookingToSave.setIdCabin(String.valueOf(cabinMatch.getId()));
        bookingToSave.setTotalTravelers(bookingInfo.getTotalTravelers());
        bookingToSave.setReserverdDate(bookingInfo.getReservedDate());

        bookingRepository.save(bookingToSave);

        // TODO -> Acionar o endpoint de fatura

        return bookingToSave.toDto();
    }

    public List<BookingDto> getAllBookings(){
        return StreamSupport
                .stream(bookingRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(BookingEntity::toDto)
                .collect(Collectors.toList());
    }

}
