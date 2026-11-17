
package com.app.covoiturage.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RechercheTrajetRequest(

        @NotBlank(message = "La ville de départ est obligatoire.")
        String villeDepart,

        @NotBlank(message = "La ville d'arrivée est obligatoire.")
        String villeArrivee,

        @NotNull(message = "La date du trajet est obligatoire.")
        LocalDate dateDepart,

        @NotNull(message = "Le nombre de places est obligatoire.")
        @Positive(message = "Le nombre de places doit être supérieur à zéro.")
        Integer nombrePlaces,

        @DecimalMin(value = "0.00", message = "Le prix maximum ne peut pas être négatif.")
        BigDecimal prixMaximum

) {
}
