
package com.app.covoiturage.dto.response;

import java.util.UUID;

public record ConducteurResponse(
        UUID id,
        String nom,
        String prenom,
        String email,
        String telephone,
        String numeroPermis
) {
}
