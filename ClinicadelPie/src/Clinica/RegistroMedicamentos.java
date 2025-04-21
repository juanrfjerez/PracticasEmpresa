package Clinica;

import java.awt.*;
import javax.swing.*;

public class RegistroMedicamentos extends JFrame {

    public RegistroMedicamentos() {
        setTitle("Registro de Medicamentos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel etiqueta = new JLabel("Esta es la plantilla de Registro de Medicamentos", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 18));
        add(etiqueta, BorderLayout.CENTER);
        
        setVisible(true);
    }
}
