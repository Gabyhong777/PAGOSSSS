/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gpf.Pagos04;

import Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario); // Guarda el nuevo usuario
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll(); // Devuelve todos los usuarios
    }

    public Usuario obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).orElse(null); // Devuelve el usuario si existe
    }

    public List<Usuario> obtenerUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre); // Devuelve una lista de usuarios con el mismo nombre
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null); // Devuelve el usuario por ID
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id); // Elimina el usuario por ID
    }
}
