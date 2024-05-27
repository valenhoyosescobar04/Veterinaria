package com.example.demo.Modelo.Controller;
import com.example.demo.Controlador.Coordinador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import com.example.demo.Interfaces.MascotaVo;

public class RegistrarMascotasController extends JDialog implements ActionListener {

        private final JPanel contentPanel = new JPanel();
        private JTextField txtIdDueno;
        private JTextField txtNombre;
        private JTextField txtRaza;
        private JButton btnCancelar;
        private JButton btnRegistrar;
        private Coordinador miCoordinador;
        private JComboBox comboBox;
        private JComboBox comboBox_1;

        public RegistrarMascotasController(VentanaPrincipal ventanaPrincipal, boolean modal, String documento) {
            super(ventanaPrincipal, modal);
            this.setSize(408, 288);
            this.setLocationRelativeTo((Component)null);
            this.getContentPane().setLayout(new BorderLayout());
            this.setTitle("Gestion de Mascotas");
            this.iniciarComponentes(documento);
        }

        private void iniciarComponentes(String documento) {
            this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.getContentPane().add(this.contentPanel, "Center");
            this.contentPanel.setLayout((LayoutManager)null);
            JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
            lblTitulo.setHorizontalAlignment(0);
            lblTitulo.setFont(new Font("Tw Cen MT", 1, 20));
            lblTitulo.setBounds(10, 10, 372, 28);
            this.contentPanel.add(lblTitulo);
            JPanel panel = new JPanel();
            panel.setBorder(new BevelBorder(0, (Color)null, (Color)null, (Color)null, (Color)null));
            panel.setBounds(10, 49, 370, 192);
            this.contentPanel.add(panel);
            panel.setLayout((LayoutManager)null);
            JLabel lblDueno = new JLabel("Id Dueño:");
            lblDueno.setBounds(199, 17, 71, 21);
            panel.add(lblDueno);
            this.txtIdDueno = new JTextField();
            this.txtIdDueno.setBounds(269, 17, 86, 20);
            panel.add(this.txtIdDueno);
            this.txtIdDueno.setColumns(10);
            JLabel lblNombre = new JLabel("Nombre:");
            lblNombre.setBounds(24, 49, 71, 21);
            panel.add(lblNombre);
            this.txtNombre = new JTextField();
            this.txtNombre.setColumns(10);
            this.txtNombre.setBounds(88, 49, 86, 20);
            panel.add(this.txtNombre);
            JLabel lblRaza = new JLabel("Raza:");
            lblRaza.setBounds(214, 49, 71, 21);
            panel.add(lblRaza);
            this.txtRaza = new JTextField();
            this.txtRaza.setColumns(10);
            this.txtRaza.setBounds(269, 49, 86, 20);
            panel.add(this.txtRaza);
            JSeparator separator = new JSeparator();
            separator.setBounds(24, 127, 331, 12);
            panel.add(separator);
            this.btnCancelar = new JButton("Cancelar");
            this.btnCancelar.addActionListener(this);
            this.btnCancelar.setBounds(271, 150, 89, 23);
            panel.add(this.btnCancelar);
            this.btnRegistrar = new JButton("Registrar");
            this.btnRegistrar.setBounds(172, 150, 89, 23);
            this.btnRegistrar.addActionListener(this);
            panel.add(this.btnRegistrar);
            JLabel lblSexo = new JLabel("Sexo:");
            lblSexo.setBounds(24, 81, 71, 21);
            panel.add(lblSexo);
            this.comboBox = new JComboBox();
            this.comboBox.setModel(new DefaultComboBoxModel(new String[]{"Macho", "Hembra"}));
            this.comboBox.setBounds(88, 81, 86, 22);
            panel.add(this.comboBox);
            JLabel lblColor = new JLabel("Color:");
            lblColor.setBounds(214, 82, 71, 21);
            panel.add(lblColor);
            this.comboBox_1 = new JComboBox();
            this.comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"Blanco", "Negro", "Café", "Gris", "Manchas"}));
            this.comboBox_1.setBounds(269, 81, 86, 22);
            panel.add(this.comboBox_1);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.btnRegistrar) {
                if (!this.txtNombre.getText().equals("") && !this.txtIdDueno.getText().equals("") && !this.txtRaza.getText().equals("")) {
                    MascotaVo miMascota = new MascotaVo();
                    miMascota.setIdMascota(Long.parseLong(this.txtIdDueno.getText()));
                    miMascota.setNombre(this.txtNombre.getText());
                    miMascota.setRaza(this.txtRaza.getText());
                    miMascota.setSexo((String)this.comboBox.getSelectedItem());
                    miMascota.setColorMascota((String)this.comboBox_1.getSelectedItem());
                    String res = this.miCoordinador.registrarMascota(miMascota);
                    if (res.equals("ok")) {
                        JOptionPane.showMessageDialog((Component)null, "Registro Exitoso!");
                        this.limpiar();
                    } else {
                        JOptionPane.showMessageDialog((Component)null, res + ", verifique que el documento se encuentre registrado", "ERROR", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Por favor llene todos los campos", "Campos incompletos", 1);
                }
            } else if (e.getSource() == this.btnCancelar) {
                this.setVisible(false);
            }

        }

        public void limpiar() {
            this.txtIdDueno.setText("");
            this.txtNombre.setText("");
            this.txtRaza.setText("");
        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }

