package com.example.demo.Modelo.Controller;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.example.demo.Controlador.Coordinador;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.example.demo.Modelo.vo.PersonaVo;
public class TotalDePersonasRegistradas extends JDialog implements ActionListener {

        private JPanel miPanel;
        private JTextArea AreaResultado;
        private Coordinador miCoordinador;
        private JButton btnConsultarTodasLasPersonas;
        private JButton btnLimpiar;

        public TotalDePersonasRegistradas() {
            this.setBounds(100, 100, 450, 300);
            this.setLocationRelativeTo((Component)null);
            this.miPanel = new JPanel();
            this.miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.setContentPane(this.miPanel);
            this.miPanel.setLayout((LayoutManager)null);
            JLabel etiTitulo = new JLabel("Total De Personas");
            etiTitulo.setFont(new Font("Tahoma", 1, 17));
            etiTitulo.setBounds(135, 11, 168, 24);
            this.miPanel.add(etiTitulo);
            this.AreaResultado = new JTextArea();
            this.AreaResultado.setLineWrap(true);
            JScrollPane scroll = new JScrollPane(this.AreaResultado, 22, 31);
            scroll.setBounds(31, 46, 375, 133);
            this.miPanel.add(scroll);
            this.btnConsultarTodasLasPersonas = new JButton("consultar");
            this.btnConsultarTodasLasPersonas.setFont(new Font("Tahoma", 1, 14));
            this.btnConsultarTodasLasPersonas.setBounds(87, 215, 99, 31);
            this.btnConsultarTodasLasPersonas.addActionListener(this);
            this.miPanel.add(this.btnConsultarTodasLasPersonas);
            this.btnLimpiar = new JButton("Limpiar");
            this.btnLimpiar.setFont(new Font("Tahoma", 1, 14));
            this.btnLimpiar.setBounds(249, 215, 99, 31);
            this.btnLimpiar.addActionListener(this);
            this.miPanel.add(this.btnLimpiar);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.btnConsultarTodasLasPersonas) {
                ArrayList<PersonaVo> persona = this.miCoordinador.consultarTodasLasPersonas();
                this.AreaResultado.setText("" + persona);
            } else if (e.getSource() == this.btnLimpiar) {
                this.AreaResultado.setText("");
            }

        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }

