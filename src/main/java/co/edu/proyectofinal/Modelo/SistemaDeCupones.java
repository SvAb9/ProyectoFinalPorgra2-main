package co.edu.proyectofinal.Modelo;

public class SistemaDeCupones extends Sujeto{
    
    public void mandarCuponNavidad(Cliente cliente){
        System.out.println("Enviando cupón Navideño: " + cliente.getUsuario());
        cliente.addCupon(new CuponNavideno());
        notificarObservers("Estamos en vísperas navideñas, por eso recibes un cupón de 15%");
    }

    public void mandarCuponHalloween(Cliente cliente){
        System.out.println("enviando cupón Hallowen: " + cliente.getUsuario());
        cliente.addCupon(new CuponHalloween());
        notificarObservers("Feliz Hallowen, por eso recibes un cupón del 20%");
    }
}
