/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gpf.Pagos04;

import Repositorio.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion crearNotificacion(Notificacion notificacion) {
        notificacion.setFechaCreacion(new Date()); // Establecer la fecha de creación a la fecha actual
        return notificacionRepository.save(notificacion); // Guarda la nueva notificación
    }

    public List<Notificacion> obtenerNotificacionesPorUsuario(Long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId); // Devuelve notificaciones del usuario
    }

    public List<Notificacion> obtenerNotificacionesNoLeidasPorUsuario(Long usuarioId) {
        return notificacionRepository.findByUsuarioIdAndLeidaFalse(usuarioId); // Devuelve notificaciones no leídas
    }

    public List<Notificacion> obtenerTodasLasNotificaciones() {
        return notificacionRepository.findAllByOrderByFechaCreacionDesc(); // Devuelve todas las notificaciones
    }

    public void marcarNotificacionComoLeida(Long id) {
        Notificacion notificacion = notificacionRepository.findById(id).orElse(null);
        if (notificacion != null) {
            notificacion.setLeida(true); // Marca la notificación como leída
            notificacionRepository.save(notificacion); // Guarda la actualización
        }
    }
    public void eliminarNotificacion(Long id) {
        notificacionRepository.deleteById(id); // Elimina la notificación por ID
    }
}

