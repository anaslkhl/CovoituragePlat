
package com.app.covoiturage.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record CreateReservationRequest(

        @NotNull(message = "L'identifiant du passager est obligatoire.")
        UUID passagerId,

        @NotNull(message = "L'identifiant du trajet est obligatoire.")
        UUID trajetId,

        @NotNull(message = "Le point de montée est obligatoire.")
        UUID pointMonteeId,

        @NotNull(message = "Le point de descente est obligatoire.")
        UUID pointDescenteId,

        @NotNull(message = "Le nombre de places est obligatoire.")
        @Positive(message = "Le nombre de places doit être supérieur à zéro.")
        Integer nombrePlaces

) {
}
