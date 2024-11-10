package com.restaurant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurant.dtos.ReservationDto;
import com.restaurant.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tableType;

    private String description;

    private Date dateTime;

    private ReservationStatus reservationStatus;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public ReservationDto getReservationDto() {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(id);
        reservationDto.setTableType(tableType);
        reservationDto.setDateTime(dateTime);
        reservationDto.setTime(dateTime);
        reservationDto.setDescription(description);
        reservationDto.setReservationStatus(reservationStatus);
        reservationDto.setCustomerId(user.getId());
        return reservationDto;
    }
}
