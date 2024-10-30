/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gpf.Pagos04;

import Repositorio.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PagoService {

    // Inyección del repositorio
    @Autowired
    private PagoRepository pagoRepository;

    // Método para realizar un nuevo pago
    public Pago realizarPago(Pago pago) {
        pago.setFechaPago(new Date()); // Establecer la fecha del pago a la fecha actual
        return pagoRepository.save(pago); // Guardar el pago en la base de datos
    }

    // Método para obtener todos los pagos de un usuario específico
    public List<Pago> obtenerPagosPorUsuario(Long usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId); // Llama al método del repositorio
    }

    // Método para obtener pagos por método de pago
    public List<Pago> obtenerPagosPorMetodo(String metodoPago) {
        return pagoRepository.findByMetodoPago(metodoPago); // Llama al método del repositorio
    }
}