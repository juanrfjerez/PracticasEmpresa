import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HojaDePedidos extends JFrame {
    private JTextField txtMedicamento, txtViaAdmin, txtCantidad;
    private JTable tablaPedidos;
    private DefaultTableModel modeloTabla;

    public HojaDePedidos() {
        setTitle("Hoja de Pedidos - Clínica de Podología");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        JLabel lblTitulo = new JLabel("Hoja de Pedidos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 36)); // Fuente grande y en negrita
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0)); // Margen superior e inferior
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrado
        
        add(lblTitulo, BorderLayout.NORTH);

        // Panel para introducir los datos del pedido
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Espacio más grande entre componentes

        txtMedicamento = new JTextField(10);
        txtViaAdmin = new JTextField(10);
        txtCantidad = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar Pedido");

        panelDatos.add(new JLabel("Medicamento:"));
        panelDatos.add(txtMedicamento);
        panelDatos.add(new JLabel("Vía de Administración:"));
        panelDatos.add(txtViaAdmin);
        panelDatos.add(new JLabel("Cantidad:"));
        panelDatos.add(txtCantidad);
        panelDatos.add(btnAgregar);

        // Tabla para mostrar los pedidos
        String[] columnNames = {"Medicamento", "Vía de Administración", "Cantidad"};
        modeloTabla = new DefaultTableModel(columnNames, 0);
        tablaPedidos = new JTable(modeloTabla);
        
        // Centrar la tabla con un panel adicional
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 50)); // Margen adicional
        panelTabla.add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);

        // Agregar componentes a la ventana
        add(panelDatos, BorderLayout.CENTER);
        add(panelTabla, BorderLayout.SOUTH); // Cambia el orden si es necesario

        // Acción del botón
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPedido();
            }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HojaDePedidos().setVisible(true);
        });
    }
}






