package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {
    private List<Observer> observers= new ArrayList<>();

    public void registrarObserver(Observer observer){
        observers.add(observer);
    }

    public void eliminarObserver(Observer observer){
        observers.remove(observer);
    }

    public void notificarObservers(String message){
        for(Observer observer: observers){
            observer.update(message);
        }
    }
}
