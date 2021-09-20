package bstorm.akimts.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;
    @Column(name = "car_brand", nullable = false)
    private String marque;
    @Column(name = "car_model", nullable = false)
    private String modele;
    @Column(name = "car_power")
    private int puissance;

    @ManyToOne
    @JoinColumn(name = "car_owner", foreignKey = @ForeignKey(name = "FK_car_person"))
    private Personne proprietaire;
}
