package bstorm.akimts.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Stream;

@Entity
@Table(name = "location")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int id;
    @Column(name = "address", nullable = false)
    private String adresse;
    @Column(name = "rent_cost", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double coutLocation;
    @Column(name = "utilities_cost", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double coutCharge;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "renter",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "renter_id"),
            foreignKey = @ForeignKey(
                    name = "FK_renter_location",
                    foreignKeyDefinition = "FOREIGN KEY (location_id) REFERENCES location(location_id)"),
            inverseForeignKey = @ForeignKey(
                    name = "FK_renter_person",
                    foreignKeyDefinition = "FOREIGN KEY (renter_id) REFERENCES person(person_id)"
            )
    )
    private List<Personne> locataires;

}
