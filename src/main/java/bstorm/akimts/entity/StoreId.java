package bstorm.akimts.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StoreId implements Serializable {

    private String nom;
    private String adresse;
}
