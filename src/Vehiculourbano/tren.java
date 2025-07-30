package Vehiculourbano;

public class tren extends vehiculo {
    private int numeroVagones;
    private String tipo;

    public int getNumeroVagones() {
        return numeroVagones;
    }

    public void setNumeroVagones(int numeroVagones) {
        this.numeroVagones = Math.max(1, numeroVagones);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equals("eléctrico") || tipo.equals("diésel")) {
            this.tipo = tipo;
        } else {
            this.tipo = "eléctrico";
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de vagones: " + numeroVagones +
                "\nTipo de tren: " + tipo);
    }
}
