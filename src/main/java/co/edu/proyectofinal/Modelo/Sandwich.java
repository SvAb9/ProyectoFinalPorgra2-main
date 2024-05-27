package co.edu.proyectofinal.Modelo;

public class Sandwich implements ComponenteSandwich {
    private String pan;
    private String relleno;
    private boolean tieneQueso;

    public Sandwich(String pan, String relleno, boolean tieneQueso) {
        this.pan = pan;
        this.relleno = relleno;
        this.tieneQueso = tieneQueso;
    }

    @Override
    public String getDescripcion() {
        String descripcion = "Pan: " + pan + ", Relleno: " + relleno;
        if (tieneQueso) {
            descripcion += ", Queso";
        }
        return descripcion;
    }

    @Override
    public double getCosto() {
        double costo = 2000; // Costo base del pan
        if (relleno != null && !relleno.isEmpty()) {
            costo += 3000; // Costo del relleno
        }
        if (tieneQueso) {
            costo += 1000; // Costo del queso
        }
        return costo;
    }

    // Getters y setters
    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }
    public String getRelleno() { return relleno; }
    public void setRelleno(String relleno) { this.relleno = relleno; }
    public boolean tieneQueso() { return tieneQueso; }
    public void setTieneQueso(boolean tieneQueso) { this.tieneQueso = tieneQueso; }
}
