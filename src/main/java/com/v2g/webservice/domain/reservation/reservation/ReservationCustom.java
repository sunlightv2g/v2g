package com.v2g.webservice.domain.reservation.reservation;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.v2g.webservice.dto.reservation.reservation.ReservationMainResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationSearchRequestDto;

public interface ReservationCustom {
    Page<ReservationMainResponseDto> getReservationList(ReservationSearchRequestDto reservationSearchResponseDto, Pageable pageable);
    long getReservationByQuerydsl(String userid);
    List<ReservationResponseDto> getTodayCost();
    List<ReservationResponseDto> getTradeHistory();
    
    /*long getReservationByQuerydsl(String userid, String userpass);*/
	/*long update(Reservation entity);*/
}