package com.greenappleexperience.demo;

import com.greenappleexperience.demo.entidades.*;
import com.greenappleexperience.demo.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp1PersistenciaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedidoRepositorio;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;


	public static void main(String[] args) {

		SpringApplication.run(Tp1PersistenciaApplication.class, args);

	}

	@Bean
	CommandLineRunner init(ClienteRepositorio clienteRepositorio,DetallePedidoRepositorio detallePedidoRepositorio,DomicilioRepositorio domicilioRepositorio, FacturaRepositorio facturaRepositorio,PedidoRepositorio pedidoRepositorio,ProductoRepositorio productoRepositorio,RubroRepositorio rubroRepositorio) {
		return args -> {

			System.out.println("Estoy funcionanding");

				Cliente cliente= Cliente.builder()
						.nombre("Sergio")
						.apellido("Albino")
						.telefono("2612574460")
						.email("sergioalbino1080@gmail.com")
						.build();


				Domicilio domicilio= Domicilio.builder()
						.calle("Rodriguez")
						.numero("273")
						.localidad("Ciudad")
						.build();

				cliente.agregarDomicilio(domicilio);


				DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(3)
					.subtotal(2400)
					.build();




				Pedido pedido = Pedido.builder()
					.estado("En preparacion")
					.fecha(new Date())
					.tipoEnvio("Delivery")
					.total(2500.0)
					.build();



				pedido.agregarDetallePedido(detallePedido);


				cliente.agregarPedido(pedido);

				Factura factura = Factura.builder()
					.numero(100)
					.fecha(new Date())
					.descuento(20.0)
					.formaPago("Mercado pago")
					.total(2500)
					.build();

				pedido.setFactura(factura);




			Producto producto = Producto.builder()
					.tipo("Comestible")
					.tiempoEstimadoCocina(30)
					.denominacion("desconocida")
					.precioVenta(1500.0)
					.precioCompra(1000.0)
					.stockActual(30)
					.stockMinimo(10)
					.unidadMedida("kg")
					.receta("Casera")
					.build();

			detallePedido.setProducto(producto);

			Rubro rubro = Rubro.builder()
					.denominacion("Chocolate")
					.build();

			rubro.agregarProducto(producto);

			clienteRepositorio.save(cliente);
			rubroRepositorio.save(rubro);





			};

		};

	}




