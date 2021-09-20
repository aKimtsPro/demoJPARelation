package bstorm.akimts.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;
    @Column(name = "person_surname", nullable = false, columnDefinition = "VARCHAR(100)")
    private String prenom;
    @Column(name = "person_name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nom;
    @Column(name = "person_birth_date", nullable = false)
    private LocalDate dateNaiss;

    @OneToMany(mappedBy = "proprietaire")
    private List<Voiture> propriete;

    @ManyToMany(mappedBy = "locataires")
    private List<Location> locations;

    @OneToOne(mappedBy = "proprietaire")
    private Compte compte;
}
