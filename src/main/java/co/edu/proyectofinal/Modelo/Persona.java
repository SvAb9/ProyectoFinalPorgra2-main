package co.edu.proyectofinal.Modelo;

public class Persona implements  GetTipo{
    private String nombre;
    private String apellido;
    public String usuario;
    private String contraseña;
    private String documento;
    private String tipo;
    public Persona(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.documento = documento;
        this.tipo= tipo;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public static Persona fromFileString (String fileString){
        String[]parts = fileString.split(";");
        if(parts.length != 6){
            throw new IllegalArgumentException("El archivo debe ser exactamente 5 elementos");
        }
        return new Persona(parts[0],parts[1],parts[2],parts[3],parts[4], parts[5]);
    }

    public  String toFileString(){
        return  nombre + "," + apellido + "," + documento + "," + usuario + "," + contraseña + "," + tipo;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
