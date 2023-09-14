package com.greenappleexperience.demo.repositorios;

import com.greenappleexperience.demo.entidades.Cliente;
import com.greenappleexperience.demo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
