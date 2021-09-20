package bstorm.akimts.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store {

    @EmbeddedId
    private StoreId id;
    private int score;

}
