
package com.app.covoiturage.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conducteurs")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Conducteur extends User {

    @Column(name = "numero_permis", nullable = false)
    private String numeroPermis;

    @OneToMany(mappedBy = "conducteur")
    @Builder.Default
    private List<Vehicule> vehicules = new ArrayList<>();
}
