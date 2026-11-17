
package com.app.covoiturage.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PointArretRequest(

        @NotBlank(message = "La ville du point d'arrêt est obligatoire.")
        String ville,

        @NotNull(message = "L'ordre du point d'arrêt est obligatoire.")
        @PositiveOrZero(message = "L'ordre doit être supérieur ou égal à zéro.")
        Integer ordre,

        @NotNull(message = "L'heure de passage est obligatoire.")
        LocalDateTime heurePassage,

        @NotNull(message = "Le prix depuis le départ est obligatoire.")
        @DecimalMin(value = "0.00", message = "Le prix ne peut pas être négatif.")
        BigDecimal prixDepuisDepart

) {
}
