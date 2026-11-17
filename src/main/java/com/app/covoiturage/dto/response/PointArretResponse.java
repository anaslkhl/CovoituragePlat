
package com.app.covoiturage.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PointArretResponse(
        UUID id,
        String ville,
        Integer ordre,
        LocalDateTime heurePassage,
        BigDecimal prixDepuisDepart,
        UUID trajetId
) {
}
