package Vehiculourbano;

public class vehiculo {

    private String id;
    private int capacidadPasajeros;
    private float velocidadMaxima;
    private String estado;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        if (capacidadPasajeros >= 0) {
            this.capacidadPasajeros = capacidadPasajeros;
        } else {
            System.out.println("Error: La capacidad de pasajeros no puede ser negativa. El registro no se completará.");

        }
    }

    public float getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(float velocidadMaxima) {
        if (velocidadMaxima > 0) {
            this.velocidadMaxima = velocidadMaxima;
        } else {
            System.out.println("Error: La velocidad máxima debe ser mayor que 0. El registro no se completará.");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado != null && (estado.equals("en servicio") || estado.equals("fuera de servicio"))) {
            this.estado = estado;
        } else {
            System.out.println("Advertencia: Estado inválido. Se asignará 'en servicio'.");
            this.estado = "en servicio";
        }
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id +
                "\nCapacidad: " + capacidadPasajeros +
                "\nVelocidad máxima: " + velocidadMaxima +
                "\nEstado: " + estado);
    }
}
