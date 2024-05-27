package Persistencia;

import co.edu.proyectofinal.Modelo.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPersistencia {

    private static final String DIRECTORY_PATH = "./persistence/txt_persistence";
    private static final String USUARIO_FILE= DIRECTORY_PATH + "/usuarios.txt";

    public UsuarioPersistencia() {
        try{
            File directory = new File(DIRECTORY_PATH);
            if(!directory.exists() && !directory.mkdirs()){
                throw  new IOException("No se pudo crear el directorio:" + DIRECTORY_PATH);
            }
            File usuario = new File(USUARIO_FILE);
            if(!usuario.exists() && !usuario.createNewFile()){
                throw new IOException(" No se pudo crear el archivo de texto:" + USUARIO_FILE);
            }
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void guardarUsuario(Persona persona) throws IOException{
        try( FileWriter fw = new FileWriter(USUARIO_FILE, true);
             BufferedWriter bw= new BufferedWriter(fw)){
            bw.write(persona.toFileString());
            bw.newLine();
        }catch(IOException e){
            System.out.println("Error al guardar el usuario" + e.getMessage());
            throw e;
        }
    }

    public List<Persona> obtenerUsuarios() throws IOException{
        List<Persona> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USUARIO_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                usuarios.add(Persona.fromFileString(linea));
            }
        }
        return usuarios;
    }

    public Persona obtenerPorUsuario(String usuario) throws IOException{
        List<Persona> usuarios = obtenerUsuarios();
        for( Persona persona : usuarios ){
            if(persona.getUsuario().equals(usuario)){
                return persona;
            }
        }
        return null;
    }

    public void actualizarUsuario(Persona actUsuario) throws IOException{
        List<Persona> usuarios = obtenerUsuarios();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIO_FILE, false))) {
            for (Persona persona : usuarios) {
                if(persona.getUsuario().equals(actUsuario.getUsuario())){
                    bw.write(actUsuario.toFileString());
                }else{
                    bw.write(persona.toFileString());
                }
                bw.newLine();
            }
        }
    }

    public void eliminarUsuario(String usuario) throws IOException{
        List<Persona> usuarios = obtenerUsuarios();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIO_FILE, false))) {
            for (Persona persona : usuarios) {
                if(persona.getUsuario().equals(usuario)){
                    bw.write(persona.toFileString());
                    bw.newLine();
                }
            }
        }
    }
}

