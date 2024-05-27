package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements Observer{
    
    private List<CuponStrategy> cupones;
    

    public Cliente(String nombre, String apellido, String usuario, String contraseña, String documento, List<CuponStrategy> cupones, String tipo) {
        super(nombre, apellido, usuario, contraseña, documento, tipo);
        this.cupones = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void addCupon(CuponStrategy cupon){
        cupones.add(cupon);
    }
    
    public List<CuponStrategy> getCupones(){
        return cupones;
    }

    public double aplicarCupon(double total, CuponStrategy cuponSeleccionado){
        return cuponSeleccionado.aplicarDescuento(total);
    }

    @Override
    public void update(String message){
        System.out.println("Notificaion para:" + getUsuario() + message );
    }
}
