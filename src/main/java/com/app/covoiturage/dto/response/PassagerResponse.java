
package com.app.covoiturage.dto.response;

import java.util.UUID;

public record PassagerResponse(
        UUID id,
        String nom,
        String prenom,
        String email,
        String telephone
) {
}
