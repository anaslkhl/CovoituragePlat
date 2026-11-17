
package com.app.covoiturage.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public record UpdateTrajetRequest(

        @NotNull(message = "La date de départ est obligatoire.")
        @Future(message = "La date de départ doit être dans le futur.")
        LocalDateTime dateDepart,

        @NotNull(message = "Le nombre de places proposées est obligatoire.")
        @Positive(message = "Le nombre de places doit être supérieur à zéro.")
        Integer placesProposees,

        @NotNull(message = "La liste des points d'arrêt est obligatoire.")
        @Size(min = 2, message = "Un trajet doit contenir au moins deux points d'arrêt.")
        List<@Valid PointArretRequest> pointsArret

) {
}
