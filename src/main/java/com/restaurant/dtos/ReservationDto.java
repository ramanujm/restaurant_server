package com.restaurant.dtos;

import com.restaurant.enums.ReservationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private Long id;

    private String tableType;

    private String description;

    private Date dateTime;

    private Date time;

    private ReservationStatus reservationStatus;

    private Long customerId;

}
