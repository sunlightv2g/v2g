package com.v2g.webservice.domain.reservation.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import com.v2g.webservice.domain.reservation.reservation.Reservation;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationCustom {
List<Reservation> findByUserid(String userid);
}