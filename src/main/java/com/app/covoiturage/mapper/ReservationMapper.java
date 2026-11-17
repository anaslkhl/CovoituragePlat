package com.app.covoiturage.mapper;

import com.app.covoiturage.domain.Reservation;
import com.app.covoiturage.dto.request.CreateReservationRequest;
import com.app.covoiturage.dto.response.ReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateReservation", ignore = true)
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "passager" ,ignore = true)
    @Mapping(target = "trajet", ignore = true)
    @Mapping(target = "pointMontee", ignore = true)
    @Mapping(target = "pointDescente", ignore = true)
    Reservation toEntity(CreateReservationRequest reservationRequest);

    @Mapping(target = "passagerId", source = "passager.id")
    @Mapping(target = "trajetId", source = "trajet.id")
    @Mapping(target = "pointMonteeId", source = "pointMontee.id")
    @Mapping(target = "pointDescenteId", source = "pointDescente.id")
    @Mapping(target = "montantTotal", ignore = true)
    ReservationResponse toResponse(Reservation reservation);
}
