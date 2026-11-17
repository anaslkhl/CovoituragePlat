
package com.app.covoiturage.dto.response;

import com.app.covoiturage.domain.enums.StatutTrajet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TrajetResponse(
        UUID id,
        LocalDateTime dateDepart,
        Integer placesProposees,
        StatutTrajet statut,
        UUID conducteurId,
        UUID vehiculeId,
        List<PointArretResponse> pointsArret
) {
}
