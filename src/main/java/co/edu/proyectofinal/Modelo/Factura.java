package co.edu.proyectofinal.Modelo;

import java.util.UUID;

public class Factura {

    private double subTotal;
    private double total;
    private UUID codigoFactura;; //codigo unico para cada factura

    private Factura (Builder builder){
        this.subTotal= builder.subTotal;
        this.total= builder.total;
        this.codigoFactura= builder.codigoFactura;

    }
    public double getSubTotal() { return subTotal; }
    public double getTotal() { return total; }
    public UUID getCodigoFactura() { return codigoFactura; }

    public static class Builder{
        private double subTotal;
        private double total;
        private UUID codigoFactura;

        public Builder subTotal(double subTotal){
            this.subTotal = subTotal;
            return this;
        }
        public Builder total(double total){
            this.total = total;
            return this;
        }
        public  Builder codigoFactura(UUID codigoFactura){
            this.codigoFactura = codigoFactura;
            return this;
        }
        public Factura build(){
            return new Factura(this);
        }
    }

    public String toFileString(){
        return  String.join(",", String.valueOf(subTotal), String.valueOf(total), codigoFactura.toString());
    }
}
