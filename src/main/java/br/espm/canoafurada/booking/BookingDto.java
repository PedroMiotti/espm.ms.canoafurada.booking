package br.espm.canoafurada.booking;

import java.util.Date;
import java.util.UUID;

public class BookingDto {
    private UUID id;
    private String idCabin;
    private String idUser;
    private java.sql.Date reservedDate;
    private int totalTravelers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdCabin() {
        return idCabin;
    }

    public void setIdCabin(String idCabin) {
        this.idCabin = idCabin;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public java.sql.Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(java.sql.Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public int getTotalTravelers() {
        return totalTravelers;
    }

    public void setTotalTravelers(int totalTravelers) {
        this.totalTravelers = totalTravelers;
    }
}
