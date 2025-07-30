package Vehiculourbano;

public class BicicletaPublica extends vehiculo {
    private boolean tieneCesta;
    private int nivelBateria;

    public boolean isTieneCesta() {
        return tieneCesta;
    }

    public void setTieneCesta(boolean tieneCesta) {
        this.tieneCesta = tieneCesta;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = Math.max(0, Math.min(nivelBateria, 100));
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tiene cesta: " + (tieneCesta ? "Sí" : "No") +
                "\nNivel de batería: " + nivelBateria + "%");
    }
}
