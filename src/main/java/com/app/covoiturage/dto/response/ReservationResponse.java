
package com.app.covoiturage.dto.response;

import com.app.covoiturage.domain.enums.StatutReservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationResponse(

        UUID id,
        UUID passagerId,
        UUID trajetId,
        UUID pointMonteeId,
        UUID pointDescenteId,
        Integer nombrePlaces,
        BigDecimal montantTotal,
        LocalDateTime dateReservation,
        StatutReservation statut

) {
}
