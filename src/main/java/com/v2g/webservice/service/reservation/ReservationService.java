package com.v2g.webservice.service.reservation;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2g.webservice.domain.reservation.reservation.Reservation;
import com.v2g.webservice.domain.reservation.reservation.ReservationRepository;
import com.v2g.webservice.dto.reservation.reservation.ReservationMainResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationResponseDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationSaveRequestDto;
import com.v2g.webservice.dto.reservation.reservation.ReservationSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Transactional
    public long save(ReservationSaveRequestDto dto){
        return reservationRepository.save(dto.toEntity()).getId();
    }
    
/*    @Transactional
    public long update(ReservationSaveRequestDto dto){
    	return reservationRepository.update(dto.toEntity());
    }*/
   
    @Transactional(readOnly = true)
    public Page<ReservationMainResponseDto> getReservationListByQueryDSL(ReservationSearchRequestDto reservationSearchResponseDto, Pageable pageable) {
        return reservationRepository.getReservationList(reservationSearchResponseDto, pageable);
    }
    
    @Transactional(readOnly = true)
    public long getReservation(String userid) {
        return reservationRepository.getReservationByQuerydsl(userid);
    }
    
    
    @Transactional
    public void getReservationDelete(long id) {
    	reservationRepository.delete(id);
    }
    
    @Transactional
    public List<ReservationResponseDto> getTodayCost(){
    	return reservationRepository.getTodayCost();
    }
    
    @Transactional
    public List<ReservationResponseDto> getTradeHistory(){
    	return reservationRepository.getTradeHistory();
    }
    
    @Transactional
    public List<Reservation> findByUserid(String userid){
    	return reservationRepository.findByUserid(userid);
    }
    
    
/*    
    @Transactional(readOnly = true)
    public long getReservation(String userid,String userpass ) {
    	return reservationRepository.getReservationByQuerydsl(userid, userpass);
    }*/
    
}