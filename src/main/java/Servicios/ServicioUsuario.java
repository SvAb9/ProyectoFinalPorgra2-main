package Servicios;

import Persistencia.UsuarioPersistencia;
import co.edu.proyectofinal.Modelo.Persona;

import java.io.IOException;
import java.util.List;

public class ServicioUsuario {

    private UsuarioPersistencia usuarioPersistencia;

    public ServicioUsuario() {
        this.usuarioPersistencia=new UsuarioPersistencia();
    }

    public void añadirUsuario (Persona usuario) throws Exception{
        System.out.println("Añadiendo usuario: " + usuario.toFileString());
        usuarioPersistencia.guardarUsuario(usuario);
    }

    public List<Persona> obtenerUsuarios() throws IOException{
        return usuarioPersistencia.obtenerUsuarios();
    }

    public Persona obtenerPorUsuario(String usuario) throws IOException{
        return usuarioPersistencia.obtenerPorUsuario(usuario);
    }

    public void actualizarUsuario (Persona usuario) throws Exception{
        usuarioPersistencia.actualizarUsuario(usuario);
    }

    public void eliminarUsuario (String usuario) throws Exception{
        usuarioPersistencia.eliminarUsuario(usuario);
    }

}

