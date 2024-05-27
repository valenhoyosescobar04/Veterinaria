package com.example.demo.Modelo.Controller;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.demo.Controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.example.demo.Modelo.vo.ProductoVo;


public class RegistrarProductosController extends JDialog implements ActionListener {

        private final JPanel contentPanel = new JPanel();
        private JTextField txtNombre;
        private JTextField txtPrecio;
        private JButton btnCancelar;
        private JButton btnRegistrar;
        private Coordinador miCoordinador;
        private JTextField txtidProducto;
        private JTextField textIdPersona;

        public RegistrarProductosController(VentanaPrincipal ventanaPrincipal, boolean modal) {
            super(ventanaPrincipal, modal);
            this.setSize(412, 235);
            this.setLocationRelativeTo((Component)null);
            this.getContentPane().setLayout(new BorderLayout());
            this.setTitle("Gestion de Mascotas");
            this.iniciarComponentes();
        }

        private void iniciarComponentes() {
            this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.getContentPane().add(this.contentPanel, "Center");
            this.contentPanel.setLayout((LayoutManager)null);
            JLabel lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
            lblTitulo.setHorizontalAlignment(0);
            lblTitulo.setFont(new Font("Tw Cen MT", 1, 20));
            lblTitulo.setBounds(10, 10, 372, 28);
            this.contentPanel.add(lblTitulo);
            JPanel panel = new JPanel();
            panel.setBorder(new BevelBorder(0, (Color)null, (Color)null, (Color)null, (Color)null));
            panel.setBounds(10, 76, 380, 109);
            this.contentPanel.add(panel);
            panel.setLayout((LayoutManager)null);
            JLabel lblNombre = new JLabel("Nombre:");
            lblNombre.setBounds(24, 11, 71, 21);
            panel.add(lblNombre);
            this.txtNombre = new JTextField();
            this.txtNombre.setColumns(10);
            this.txtNombre.setBounds(88, 11, 86, 20);
            panel.add(this.txtNombre);
            JLabel lblPrecio = new JLabel("Precio:");
            lblPrecio.setBounds(214, 11, 71, 21);
            panel.add(lblPrecio);
            this.txtPrecio = new JTextField();
            this.txtPrecio.setColumns(10);
            this.txtPrecio.setBounds(271, 11, 86, 20);
            panel.add(this.txtPrecio);
            JSeparator separator = new JSeparator();
            separator.setBounds(24, 43, 331, 12);
            panel.add(separator);
            this.btnCancelar = new JButton("Cancelar");
            this.btnCancelar.setBounds(271, 66, 89, 23);
            this.btnCancelar.addActionListener(this);
            panel.add(this.btnCancelar);
            this.btnRegistrar = new JButton("Registrar");
            this.btnRegistrar.setBounds(172, 66, 89, 23);
            this.btnRegistrar.addActionListener(this);
            panel.add(this.btnRegistrar);
            JLabel etiProducto = new JLabel("Id Producto:");
            etiProducto.setBounds(195, 49, 75, 21);
            this.contentPanel.add(etiProducto);
            this.txtidProducto = new JTextField();
            this.txtidProducto.setColumns(10);
            this.txtidProducto.setBounds(280, 49, 86, 20);
            this.contentPanel.add(this.txtidProducto);
            JLabel etiIdPersona = new JLabel("Id Persona:");
            etiIdPersona.setBounds(30, 49, 75, 21);
            this.contentPanel.add(etiIdPersona);
            this.textIdPersona = new JTextField();
            this.textIdPersona.setColumns(10);
            this.textIdPersona.setBounds(92, 49, 86, 20);
            this.contentPanel.add(this.textIdPersona);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.btnRegistrar) {
                if (!this.textIdPersona.getText().equals("") && !this.txtidProducto.getText().equals("") && !this.txtNombre.getText().equals("") && !this.txtPrecio.getText().equals("")) {
                    ProductoVo miProducto = new ProductoVo();
                    int id = Integer.parseInt(this.textIdPersona.getText());
                    miProducto.setIdProducto(Long.parseLong(this.txtidProducto.getText()));
                    miProducto.setNombreProducto(this.txtNombre.getText());
                    miProducto.setPrecioProducto(Double.parseDouble(this.txtPrecio.getText()));
                    String veri = this.miCoordinador.comprobarIdUsuario(id);
                    if (veri.equals("ok")) {
                        String res = this.miCoordinador.registrarProducto(miProducto, id);
                        if (res.equals("ok")) {
                            JOptionPane.showMessageDialog((Component)null, "Registro Exitoso!");
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "El ID del producto ya está registrado, intente con otro número", "ERROR", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "El documento no está registrado", "ERROR", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Por favor llene todos los campos", "Campos incompletos", 1);
                }
            } else if (e.getSource() == this.btnCancelar) {
                this.setVisible(false);
            }

        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }

        public void limpiar() {
            this.txtidProducto.setText("");
            this.txtNombre.setText("");
            this.txtPrecio.setText("");
        }
    }
