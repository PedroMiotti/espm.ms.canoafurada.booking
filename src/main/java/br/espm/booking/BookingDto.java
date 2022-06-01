package br.espm.booking;

import java.util.Date;
import java.util.UUID;

public class BookingDto {
    private UUID id;
    private UUID idCabin;
    private Date reservedDate;
    private int totalTravelers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCabin() {
        return idCabin;
    }

    public void setIdCabin(UUID idCabin) {
        this.idCabin = idCabin;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public int getTotalTravelers() {
        return totalTravelers;
    }

    public void setTotalTravelers(int totalTravelers) {
        this.totalTravelers = totalTravelers;
    }
}
