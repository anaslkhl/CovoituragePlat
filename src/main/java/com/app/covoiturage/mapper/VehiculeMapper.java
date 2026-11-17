package com.app.covoiturage.mapper;

import com.app.covoiturage.domain.Vehicule;
import com.app.covoiturage.dto.request.CreateVehiculeRequest;
import com.app.covoiturage.dto.request.UpdateVehiculeRequest;
import com.app.covoiturage.dto.response.VehiculeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "conducteur", ignore = true)
    Vehicule toEntity(CreateVehiculeRequest request);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "conducteur", ignore = true)
    void toEntity(UpdateVehiculeRequest request,
                  @MappingTarget Vehicule vehicule);


    @Mapping(target = "conducteurId", source = "conducteur.id")
    VehiculeResponse toResponse(Vehicule vehicule);
}
