package co.edu.proyectofinal.Modelo;

import java.util.Stack;

public class OrdenCaretaker {
    private Stack<OrdenMemento> historial = new Stack<>();
    private Stack<OrdenMemento> rehacerHistorial = new Stack<>();

    public void guardarMemento(Orden orden) {
        historial.push(orden.guardar());
        rehacerHistorial.clear(); // Limpiar el historial de rehacer después de guardar un nuevo estado
    }

    public void deshacer(Orden orden) {
        if (!historial.isEmpty()) {
            OrdenMemento memento = historial.pop();
            rehacerHistorial.push(orden.guardar());
            orden.restaurar(memento);
        } else {
            System.out.println("No hay nada que deshacer.");
        }
    }

    public void rehacer(Orden orden) {
        if (!rehacerHistorial.isEmpty()) {
            OrdenMemento memento = rehacerHistorial.pop();
            historial.push(orden.guardar());
            orden.restaurar(memento);
        } else {
            System.out.println("No hay nada que rehacer.");
        }
    }
}    
