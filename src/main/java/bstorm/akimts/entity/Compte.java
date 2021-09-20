package bstorm.akimts.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {

    @Id
    private String isbn;
    @Column(name = "balance", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double solde;
    @Column(name = "bank_name", nullable = false)
    private String nomBanque;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = false, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "account_owner", foreignKey = @ForeignKey(name = "FK_account_person"))
    private Personne proprietaire;
}
