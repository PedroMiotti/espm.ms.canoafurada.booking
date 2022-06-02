package br.espm.canoafurada.booking;

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

    @Column(name = "id_cabin", nullable = false, columnDefinition = "char(36)")
    private String idCabin;

    @Column(name = "id_user", nullable = false, columnDefinition = "char(36)")
    private String idUser;

    @Column(name = "reserved_date", nullable = false)
    private java.sql.Date reserverdDate;

    @Column(name = "total_travelers", nullable = false)
    private int totalTravelers;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCabin() {
        return idCabin;
    }

    public void setIdCabin(String idCabin) {
        this.idCabin = idCabin;
    }

    public java.sql.Date getReserverdDate() {
        return reserverdDate;
    }

    public void setReserverdDate(java.sql.Date reserverdDate) {
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
        booking.setIdUser(idUser);
        booking.setReservedDate(reserverdDate);
        booking.setTotalTravelers(totalTravelers);

        return booking;
    }
}
