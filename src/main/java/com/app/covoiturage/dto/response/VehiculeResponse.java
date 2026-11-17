
package com.app.covoiturage.dto.response;

import java.util.UUID;

public record VehiculeResponse(
        UUID id,
        String marque,
        String modele,
        String immatriculation,
        String couleur,
        Integer capacite,
        UUID conducteurId
) {
}
