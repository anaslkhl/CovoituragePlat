package com.app.covoiturage.mapper;

import com.app.covoiturage.domain.PointArret;
import com.app.covoiturage.dto.request.CreateVehiculeRequest;
import com.app.covoiturage.dto.request.PointArretRequest;
import com.app.covoiturage.dto.response.PointArretResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PointArretMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "trajet", ignore = true)
    PointArret toEntity(PointArretRequest request);

    @Mapping(target = "trajetId", source = "trajet.id")
    PointArretResponse toResponse(PointArret pointArret);


}
