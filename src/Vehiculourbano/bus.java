package Vehiculourbano;

public class bus extends vehiculo {
    private String rutaAsignada;
    private int numeroPisos;

    public bus() {
        super();
    }

    public String getRutaAsignada() {
        return rutaAsignada;
    }

    public void setRutaAsignada(String rutaAsignada) {
        this.rutaAsignada = rutaAsignada;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = Math.max(1, numeroPisos);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Ruta asignada: " + rutaAsignada +
                "\nNúmero de pisos: " + numeroPisos);
    }
}
