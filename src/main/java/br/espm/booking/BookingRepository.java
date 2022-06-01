package br.espm.booking;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookingRepository extends CrudRepository<BookingEntity, UUID> {
}
