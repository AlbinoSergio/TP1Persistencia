package com.greenappleexperience.demo.repositorios;

import com.greenappleexperience.demo.entidades.Cliente;
import com.greenappleexperience.demo.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Long> {
}
