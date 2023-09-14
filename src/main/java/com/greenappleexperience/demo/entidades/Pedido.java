package com.greenappleexperience.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido implements Serializable {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
       private Long id;
       private Date fecha;
       private String tipoEnvio;
       private Double total;
       private String estado;

       @OneToOne(cascade = CascadeType.ALL)
       @JoinColumn(name = "factura_id")
       private Factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "Pedido_id")
    private List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();

    public void agregarDetallePedido(DetallePedido detallePedido){

        detallePedidoList.add(detallePedido);

    }

    public void mostrarDetallePedido(){

        for (DetallePedido detallePedido : detallePedidoList){

            System.out.println("La cantidad es:"+detallePedido.getCantidad()+"El subtotal es:"+detallePedido.getSubtotal());

        }
    }


}
