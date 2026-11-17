
package com.app.covoiturage.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record CreateVehiculeRequest(

        @NotBlank(message = "La marque du véhicule est obligatoire.")
        String marque,

        @NotBlank(message = "Le modèle du véhicule est obligatoire.")
        String modele,

        @NotBlank(message = "L'immatriculation du véhicule est obligatoire.")
        String immatriculation,

        @NotBlank(message = "La couleur du véhicule est obligatoire.")
        String couleur,

        @NotNull(message = "La capacité du véhicule est obligatoire.")
        @Min(value = 1, message = "La capacité minimale est de 1 place.")
        @Max(value = 8, message = "La capacité maximale est de 8 places.")
        Integer capacite,

        @NotNull(message = "L'identifiant du conducteur est obligatoire.")
        UUID conducteurId

) {
}
