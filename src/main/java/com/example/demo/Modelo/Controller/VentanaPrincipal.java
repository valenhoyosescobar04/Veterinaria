package com.example.demo.Modelo.Controller;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.demo.Controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class VentanaPrincipal extends JFrame implements ActionListener {

        private JPanel contentPane;
        private AbstractButton itemRegistrarPersonas;
        private JMenuItem itemGestonPersonas;
        private JMenuItem itemRegistrarMascotas;
        private JMenuItem itemGestionMascota;
        private JMenuItem itemGestionProducto;
        private JMenuItem itemRegistroProductos;
        private Coordinador miCoordinador;
        private JMenuItem itemListaTotal;

        public VentanaPrincipal() {
            this.iniciarComponentes();
            this.setDefaultCloseOperation(3);
            this.setSize(600, 500);
            this.setResizable(false);
            this.setTitle("Patitas y garritas");
            this.setLocationRelativeTo((Component)null);
        }

        private void iniciarComponentes() {
            JMenuBar menuBar = new JMenuBar();
            this.setJMenuBar(menuBar);
            JMenu menuPersonas = new JMenu("Gestionar Personas");
            menuBar.add(menuPersonas);
            this.itemRegistrarPersonas = new JMenuItem("Registrar");
            this.itemRegistrarPersonas.addActionListener(this);
            menuPersonas.add(this.itemRegistrarPersonas);
            this.itemGestonPersonas = new JMenuItem("Gestion De Personas");
            this.itemGestonPersonas.addActionListener(this);
            menuPersonas.add(this.itemGestonPersonas);
            this.itemListaTotal = new JMenuItem("Lista total de Personas");
            this.itemListaTotal.addActionListener(this);
            menuPersonas.add(this.itemListaTotal);
            JMenu MenuMascotas = new JMenu("Gestionar Mascotas");
            menuBar.add(MenuMascotas);
            this.itemRegistrarMascotas = new JMenuItem("Registrar");
            this.itemRegistrarMascotas.addActionListener(this);
            MenuMascotas.add(this.itemRegistrarMascotas);
            this.itemGestionMascota = new JMenuItem("Gestion De Mascotas");
            this.itemGestionMascota.addActionListener(this);
            MenuMascotas.add(this.itemGestionMascota);
            JMenu menuProductos = new JMenu("Gestionar Productos");
            menuBar.add(menuProductos);
            this.itemRegistroProductos = new JMenuItem("Registrar");
            this.itemRegistroProductos.addActionListener(this);
            menuProductos.add(this.itemRegistroProductos);
            this.itemGestionProducto = new JMenuItem("Gestion de Productos");
            this.itemGestionProducto.addActionListener(this);
            menuProductos.add(this.itemGestionProducto);
            this.contentPane = new JPanel();
            this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.setContentPane(this.contentPane);
            this.contentPane.setLayout(new BorderLayout(0, 0));
            JLabel lblTitulo = new JLabel("GESTION CLINICA VETERINARIA");
            lblTitulo.setHorizontalAlignment(0);
            lblTitulo.setFont(new Font("Trebuchet MS", 1, 20));
            this.contentPane.add(lblTitulo, "North");
            JPanel panel = new JPanel();
            this.contentPane.add(panel, "Center");
            panel.setLayout(new BorderLayout(0, 0));
            JPanel panel_1 = new JPanel();
            panel.add(panel_1, "South");
            JLabel lblImagen = new JLabel();
            lblImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/veterinario.jpg")));
            panel.add(lblImagen, "West");
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.itemRegistrarPersonas) {
                this.miCoordinador.mostrarVentanaRegistroPersonas();
            } else if (e.getSource() == this.itemRegistrarMascotas) {
                this.miCoordinador.mostrarVentanaRegistroMascotas();
            } else if (e.getSource() == this.itemRegistroProductos) {
                this.miCoordinador.registrarVentanaRegistrarProductos();
            } else if (e.getSource() == this.itemGestonPersonas) {
                this.miCoordinador.mostrarVentanaConsultaPersona();
            } else if (e.getSource() == this.itemGestionMascota) {
                this.miCoordinador.mostrarVentanaConsultaMascotas();
            } else if (e.getSource() == this.itemGestionProducto) {
                this.miCoordinador.mostrarVentanaConsultarProductos();
            } else if (e.getSource() == this.itemListaTotal) {
                this.miCoordinador.mostrarVentanaTotalDePersonasRegistradas();
            }

        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }

