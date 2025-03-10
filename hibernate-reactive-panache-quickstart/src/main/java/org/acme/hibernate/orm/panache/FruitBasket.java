package org.acme.hibernate.orm.panache;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "fruit_basket")
public class FruitBasket extends PanacheEntity {

    @Column
    public String name;

    // Just in case you get it running, to prevent issues with api json gen (cycle).
    @JsonIgnore
    @OneToMany(mappedBy = "basket", fetch = FetchType.LAZY)
    public Collection<Fruit> fruits;
}
