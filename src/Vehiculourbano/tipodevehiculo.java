package Vehiculourbano;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class tipodevehiculo extends JFrame {

    private ArrayList<vehiculo> listaVehiculos = new ArrayList<>();

    public tipodevehiculo() {
        setTitle("🚗 Registro de Vehículos Urbanos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnBus = new JButton("🚌 Crear Autobús");
        JButton btnTren = new JButton("🚆 Crear Tren");
        JButton btnBici = new JButton("🚲 Crear Bicicleta Pública");
        JButton btnMostrar = new JButton("📋 Mostrar Vehículos");
        JButton btnSalir = new JButton("❌ Salir");

        add(btnBus);
        add(btnTren);
        add(btnBici);
        add(btnMostrar);
        add(btnSalir);

        btnBus.addActionListener(e -> crearBus());
        btnTren.addActionListener(e -> crearTren());
        btnBici.addActionListener(e -> crearBici());
        btnMostrar.addActionListener(e -> mostrarVehiculos());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void crearBus() {
        bus nuevo = new bus();
        llenarDatosComunes(nuevo);
        nuevo.setRutaAsignada(JOptionPane.showInputDialog("Ruta asignada:"));
        nuevo.setNumeroPisos(Integer.parseInt(JOptionPane.showInputDialog("Número de pisos:")));
        listaVehiculos.add(nuevo);
        JOptionPane.showMessageDialog(this, "✅ Autobús registrado.");
    }

    private void crearTren() {
        tren nuevo = new tren();
        llenarDatosComunes(nuevo);
        nuevo.setNumeroVagones(Integer.parseInt(JOptionPane.showInputDialog("Número de vagones:")));
        nuevo.setTipo(JOptionPane.showInputDialog("Tipo (eléctrico/diésel):"));
        listaVehiculos.add(nuevo);
        JOptionPane.showMessageDialog(this, "✅ Tren registrado.");
    }

    private void crearBici() {
        BicicletaPublica nueva = new BicicletaPublica();
        llenarDatosComunes(nueva);
        nueva.setTieneCesta(Boolean.parseBoolean(JOptionPane.showInputDialog("¿Tiene cesta? (true/false):")));
        nueva.setNivelBateria(Integer.parseInt(JOptionPane.showInputDialog("Nivel de batería (0-100):")));
        listaVehiculos.add(nueva);
        JOptionPane.showMessageDialog(this, "✅ Bicicleta registrada.");
    }

    private void llenarDatosComunes(vehiculo v) {
        v.setId(JOptionPane.showInputDialog("ID del vehículo:"));
        v.setCapacidadPasajeros(Integer.parseInt(JOptionPane.showInputDialog("Capacidad de pasajeros:")));
        v.setVelocidadMaxima(Float.parseFloat(JOptionPane.showInputDialog("Velocidad máxima:")));
        v.setEstado(JOptionPane.showInputDialog("Estado (en servicio/fuera de servicio):"));
    }

    private void mostrarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ No hay vehículos registrados.");
            return;
        }

        StringBuilder info = new StringBuilder();
        for (vehiculo v : listaVehiculos) {
            info.append("────────────────────────────\n");
            info.append("ID: ").append(v.getId()).append("\n");
            info.append("Capacidad: ").append(v.getCapacidadPasajeros()).append("\n");
            info.append("Velocidad: ").append(v.getVelocidadMaxima()).append("\n");
            info.append("Estado: ").append(v.getEstado()).append("\n");

            if (v instanceof bus b) {
                info.append("Se registro un Bus ");
                info.append("Ruta: ").append(b.getRutaAsignada()).append("\n");
                info.append("Pisos: ").append(b.getNumeroPisos()).append("\n");
            } else if (v instanceof tren t) {
                info.append("Se registro un Tren ");
                info.append("Vagones: ").append(t.getNumeroVagones()).append("\n");
                info.append("Tipo: ").append(t.getTipo()).append("\n");
            } else if (v instanceof BicicletaPublica bp) {
                info.append("Se registro una bicicleta ");
                info.append("Cesta: ").append(bp.isTieneCesta() ? "Sí" : "No").append("\n");
                info.append("Batería: ").append(bp.getNivelBateria()).append("%\n");
            }

            info.append("\n");
        }

        JTextArea textArea = new JTextArea(info.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 200));
        JOptionPane.showMessageDialog(this, scrollPane, "📋 Vehículos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            tipodevehiculo app = new tipodevehiculo();
            app.setVisible(true);
        });
    }
}
