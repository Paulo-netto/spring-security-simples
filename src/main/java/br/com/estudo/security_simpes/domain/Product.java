package br.com.estudo.security_simpes.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TB_PRODUTO")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;
    private BigDecimal price;
}
