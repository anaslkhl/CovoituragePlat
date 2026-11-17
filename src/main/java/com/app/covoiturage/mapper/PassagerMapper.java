package com.app.covoiturage.mapper;

import com.app.covoiturage.domain.Passager;
import com.app.covoiturage.dto.request.CreatePassagerRequest;
import com.app.covoiturage.dto.response.PassagerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PassagerMapper {


    @Mapping(target = "id", ignore = true)
    Passager toEntity(CreatePassagerRequest request);

    PassagerResponse toResponse(Passager passager);

}
