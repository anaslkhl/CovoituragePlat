
package com.app.covoiturage.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(

        @NotBlank(message = "Le nom est obligatoire.")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire.")
        String prenom,

        @NotBlank(message = "L'adresse email est obligatoire.")
        @Email(message = "L'adresse email doit être valide.")
        String email,

        @NotBlank(message = "Le numéro de téléphone est obligatoire.")
        String telephone

) {
}
