package com.mycoolprojects.shopmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="`Order`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("order")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("order")
    private List<OrderedProducts> ordered_products;
}
