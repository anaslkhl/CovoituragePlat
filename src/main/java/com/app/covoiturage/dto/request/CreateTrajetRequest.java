
package com.app.covoiturage.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateTrajetRequest(

        @NotNull(message = "La date de départ est obligatoire.")
        @Future(message = "La date de départ doit être dans le futur.")
        LocalDateTime dateDepart,

        @NotNull(message = "Le nombre de places proposées est obligatoire.")
        @Positive(message = "Le nombre de places doit être supérieur à zéro.")
        Integer placesProposees,

        @NotNull(message = "L'identifiant du conducteur est obligatoire.")
        UUID conducteurId,

        @NotNull(message = "L'identifiant du véhicule est obligatoire.")
        UUID vehiculeId,

        @Size(min = 2, message = "Un trajet doit contenir au moins deux points d'arrêt.")
        List<@Valid PointArretRequest> pointsArret

) {
}
