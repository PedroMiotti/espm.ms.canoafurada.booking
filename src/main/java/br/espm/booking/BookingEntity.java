package br.espm.booking;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity(name = "booking")
public class BookingEntity {

    public BookingEntity(){}

    public BookingEntity(BookingDto booking){
        this.idCabin = booking.getIdCabin();
        this.reserverdDate = booking.getReservedDate();
        this.totalTravelers = booking.getTotalTravelers();
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "idCabin", nullable = false)
    private UUID idCabin;

    @Column(name = "reservedDate", nullable = false)
    private Date reserverdDate;

    @Column(name = "totalTravelers", nullable = false)
    private int totalTravelers;


    public UUID getIdCabin() {
        return idCabin;
    }

    public void setIdCabin(UUID idCabin) {
        this.idCabin = idCabin;
    }

    public Date getReserverdDate() {
        return reserverdDate;
    }

    public void setReserverdDate(Date reserverdDate) {
        this.reserverdDate = reserverdDate;
    }

    public int getTotalTravelers() {
        return totalTravelers;
    }

    public void setTotalTravelers(int totalTravelers) {
        this.totalTravelers = totalTravelers;
    }

    public BookingDto toDto(){
        var booking = new BookingDto();
        booking.setId(id);
        booking.setIdCabin(idCabin);
        booking.setReservedDate(reserverdDate);
        booking.setTotalTravelers(totalTravelers);

        return booking;
    }
}
