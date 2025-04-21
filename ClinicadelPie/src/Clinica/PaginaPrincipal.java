package Clinica;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class PaginaPrincipal extends JFrame {

    public PaginaPrincipal() {
        setTitle("Clínica del Pie Vanesa Pinto");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Abrir en pantalla completa
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Esto hace que la ventana se abra maximizada
        setUndecorated(false); // Esto es opcional, si quieres mantener el borde de la ventana.

        // Panel de Título con Imagen
        JLabel titulo = new JLabel();
        
        // Cargar la imagen desde un enlace de Internet
        try {
            // Usamos el enlace que me diste
            URL url = new URL("https://clinicadelpievanesapinto.es/wp-content/uploads/2022/07/Logo-Pinto-sin-fondo-ni-direccion.pdf-e1658481562665-1024x158.png");
            ImageIcon imageIcon = new ImageIcon(url);
            titulo.setIcon(imageIcon);
        } catch (Exception e) {
            e.printStackTrace(); // Si la imagen no se carga, muestra el error
        }

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
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
            // Aquí no usamos 'this.dispose()' para evitar que cierre la ventana principal
            new HojaDePedidos().setVisible(true);  // Abre la ventana HojaDePedidos
        });

        panelCentral.add(btnRegistro);
        panelCentral.add(btnHojaPedidos);
        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaginaPrincipal().setVisible(true));
    }
}


