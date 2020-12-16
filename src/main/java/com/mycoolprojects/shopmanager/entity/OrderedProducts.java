package com.mycoolprojects.shopmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long quantity;

    @OneToOne
    @JoinColumn(unique = true)
    @JsonIgnoreProperties("ordered_products")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    @JsonIgnoreProperties("ordered_products")
    private Order order;
}
