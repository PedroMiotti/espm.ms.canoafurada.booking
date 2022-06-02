package br.espm.canoafurada.booking;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends CrudRepository<BookingEntity, UUID> {

    List<BookingEntity> findAllByReserverdDate(Date reservedDate);

    @Override
    List<BookingEntity> findAll();
}
