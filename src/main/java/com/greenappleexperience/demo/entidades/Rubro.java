package com.greenappleexperience.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String denominacion;

    @OneToMany(cascade = CascadeType.REFRESH,orphanRemoval = true,fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "Rubro_id")
    private List<Producto> productoList = new ArrayList<Producto>();

    public void agregarProducto(Producto producto){

        productoList.add(producto);

    }

    public void mostrarProductos(){

        for (Producto producto : productoList){

            System.out.println("El tipo de producto es:"+producto.getTipo()+"El tiempo estimado de cocina es:"+producto.getTiempoEstimadoCocina()+"La denominacion es:"+producto.getDenominacion()+"El precio de venta es:"+producto.getPrecioVenta()+"El precio de compra es"+producto.getPrecioCompra()+"El stock actual del producto es:"+producto.getStockActual()+"El stock minimo del producto es:"+producto.getStockMinimo()+"La unidad de medida es:"+producto.getUnidadMedida()+"La receta es:"+producto.getReceta());

        }
    }

}
