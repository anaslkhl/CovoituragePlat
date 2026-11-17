package com.app.covoiturage.mapper;


import com.app.covoiturage.domain.Trajet;
import com.app.covoiturage.dto.request.CreateTrajetRequest;
import com.app.covoiturage.dto.request.UpdateTrajetRequest;
import com.app.covoiturage.dto.response.TrajetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = PointArretMapper.class)
public interface TrajetMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "conducteur", ignore = true)
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Trajet toEntity(CreateTrajetRequest request);

    @Mapping(target = "dateDepart", source = "dateDepart")
    @Mapping(target = "placesProposee", source = "placesProposee")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "statut", ignore = true)
    @Mapping(target = "conducteur", ignore = true)
    @Mapping(target = "vehicule", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    void updateEntity(UpdateTrajetRequest updateTrajetRequest, @MappingTarget Trajet trajet);


    @Mapping(target = "conducteurId", source = "conducteur.id")
    @Mapping(target = "vehiculeId",source = "vehicule.id")
    TrajetResponse toResponse(Trajet trajet);



}
