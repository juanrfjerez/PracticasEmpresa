import java.awt.*;
import javax.swing.*;

public class PaginaPrincipal extends JFrame {

    public PaginaPrincipal() {
        setTitle("Clínica del Pie Vanesa Pinto");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel titulo = new JLabel("Clínica del Pie Vanesa Pinto", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        add(titulo, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 2, 30, 0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Botón Registro de Medicamentos
        JButton btnRegistro = new JButton("<html><center>Registro<br>de Medicamentos</center></html>");
        btnRegistro.setFont(new Font("Arial", Font.PLAIN, 20));
        btnRegistro.setPreferredSize(new Dimension(200, 150));
        btnRegistro.addActionListener(e -> {
            new RegistroMedicamentos();
        });

        // Botón Hoja de Pedidos
        JButton btnHojaPedidos = new JButton("<html><center>Hoja<br>de Pedidos</center></html>");
        btnHojaPedidos.setFont(new Font("Arial", Font.PLAIN, 20));
        btnHojaPedidos.setPreferredSize(new Dimension(200, 150));
        btnHojaPedidos.addActionListener(e -> {
            new HojaDePedidos().setVisible(true);
            this.dispose(); // Cierra la ventana principal
        });

        panelCentral.add(btnRegistro);
        panelCentral.add(btnHojaPedidos);
        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaginaPrincipal().setVisible(true));
    }
}
