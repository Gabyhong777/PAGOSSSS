/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import com.gpf.Pagos04.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    // Método para encontrar notificaciones por usuario
    List<Notificacion> findByUsuarioId(Long usuarioId);

    // Método para encontrar notificaciones no leídas por usuario
    List<Notificacion> findByUsuarioIdAndLeidaFalse(Long usuarioId);
    
    // Método para encontrar todas las notificaciones
    List<Notificacion> findAllByOrderByFechaCreacionDesc();
}