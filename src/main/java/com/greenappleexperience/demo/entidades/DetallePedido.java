package com.greenappleexperience.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private int cantidad;
    private double subtotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Producto_id")
    private Producto producto;


}
