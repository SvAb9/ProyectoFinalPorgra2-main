package co.edu.proyectofinal.Modelo;

import java.util.Stack;

public class OrdenCaretaker {
    private Stack<OrdenMemento> historial = new Stack<>();
    private Stack<OrdenMemento> rehacerHistorial = new Stack<>();

    public void guardarMemento(Orden orden) {
        historial.push(orden.guardar());

    }

    public void deshacer(Orden orden) {
        if (!historial.isEmpty()) {
            OrdenMemento memento = historial.pop();
            orden.restaurar(memento);
            System.out.println("Deshacer realizado");
        } else {
            System.out.println("No hay nada que deshacer.");
        }
    }

    public void rehacer(Orden orden) {
        if (!rehacerHistorial.isEmpty()) {
            OrdenMemento memento = rehacerHistorial.pop();
            historial.push(orden.guardar());
            orden.restaurar(memento);
            System.out.println("Rehacer realizado");
        } else {
            System.out.println("No hay nada que rehacer.");
        }
    }
}    
