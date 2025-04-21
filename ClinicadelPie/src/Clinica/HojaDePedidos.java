package Clinica;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HojaDePedidos extends JFrame {
    private JTextField txtMedicamento, txtViaAdmin, txtCantidad;
    private JTable tablaPedidos;
    private DefaultTableModel modeloTabla;

    public HojaDePedidos() {
        setTitle("Hoja de Pedidos - Clínica de Podología");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Título
        JLabel lblTitulo = new JLabel("Hoja de Pedidos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblTitulo);

        // Panel de entrada de datos
        JPanel panelDatos = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtMedicamento = new JTextField(10);
        txtViaAdmin = new JTextField(10);
        txtCantidad = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar Pedido");
        JButton btnDescargar = new JButton("Descargar Pedido");

        panelDatos.add(new JLabel("Medicamento:"));
        panelDatos.add(txtMedicamento);
        panelDatos.add(new JLabel("Vía de Administración:"));
        panelDatos.add(txtViaAdmin);
        panelDatos.add(new JLabel("Cantidad:"));
        panelDatos.add(txtCantidad);
        panelDatos.add(btnAgregar);
        add(panelDatos);

        // Panel para el botón "Descargar Pedido"
        JPanel panelDescargar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelDescargar.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panelDescargar.add(btnDescargar);
        add(panelDescargar);

        // Tabla de pedidos
        String[] columnNames = {"Medicamento", "Vía de Administración", "Cantidad"};
        modeloTabla = new DefaultTableModel(columnNames, 0);
        tablaPedidos = new JTable(modeloTabla);
        tablaPedidos.setFillsViewportHeight(true);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelTabla.add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);
        add(panelTabla);

        // Panel del botón "Eliminar"
        JPanel panelBotonEliminar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnEliminar = new JButton("Eliminar Pedido");
        btnEliminar.addActionListener(e -> eliminarPedido());
        panelBotonEliminar.add(btnEliminar);
        add(panelBotonEliminar);

        // Funcionalidades
        btnAgregar.addActionListener(e -> agregarPedido());

        btnDescargar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidad para descargar pedidos no implementada.");
        });
    }

    private void agregarPedido() {
        String medicamento = txtMedicamento.getText().trim();
        String viaAdmin = txtViaAdmin.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();

        if (medicamento.isEmpty() || viaAdmin.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            modeloTabla.addRow(new Object[]{medicamento, viaAdmin, cantidad});
            txtMedicamento.setText("");
            txtViaAdmin.setText("");
            txtCantidad.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.");
        }
    }

    private void eliminarPedido() {
        int row = tablaPedidos.getSelectedRow();
        if (row >= 0) {
            modeloTabla.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un pedido para eliminar.");
        }
    }
}






