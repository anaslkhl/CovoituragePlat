
package com.app.covoiturage.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TrajetRechercheResponse(

        UUID id,
        String villeDepart,
        String villeArrivee,
        LocalDateTime dateDepart,
        Integer placesRestantes,
        BigDecimal prixSegment

) {
}
