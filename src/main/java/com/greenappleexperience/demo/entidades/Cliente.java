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
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "Cliente_id")
    private List<Domicilio> domicilioList = new ArrayList<Domicilio>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "Cliente_id")
    private List<Pedido> pedidoList = new ArrayList<Pedido>();

    public void agregarDomicilio(Domicilio dom){

        domicilioList.add(dom);

    }

    public void agregarPedido(Pedido pedido){

        pedidoList.add(pedido);

    }

    public void mostrarPedidos(){

        for (Pedido pedido : pedidoList){

            System.out.println("El estado del pedido es:"+pedido.getEstado()+"La fecha en la que se realizo es:"+pedido.getFecha()+"El tipo de envio es:"+pedido.getTipoEnvio()+"El total es:"+pedido.getTotal());

        }
    }

    public void mostrarDomicilio(){

        for (Domicilio domicilio : domicilioList){

            System.out.println("La calle es: "+domicilio.getCalle()+"El numero es:"+domicilio.getNumero()+"La localidad es:"+domicilio.getLocalidad());

        }

    }

}
