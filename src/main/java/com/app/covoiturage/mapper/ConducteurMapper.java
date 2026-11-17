package com.app.covoiturage.mapper;

import com.app.covoiturage.domain.Conducteur;
import com.app.covoiturage.dto.request.CreateConducteurRequest;
import com.app.covoiturage.dto.response.ConducteurResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConducteurMapper {

    @Mapping(target = "id", ignore = true)
    Conducteur toEntity(CreateConducteurRequest request);

    ConducteurResponse toResponse(Conducteur conducteur);
}
