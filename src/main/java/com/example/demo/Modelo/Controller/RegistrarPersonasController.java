package com.example.demo.Modelo.Controller;

import com.example.demo.Controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.example.demo.Modelo.vo.NacimientoVo;
import com.example.demo.Modelo.vo.PersonaVo;

public class RegistrarPersonasController extends JDialog implements ActionListener {

        private final JPanel contentPanel = new JPanel();
        private JTextField txtDocumento;
        private JTextField txtNombre;
        private JTextField txtTelefono;
        private JTextField txtProfesion;
        private JTextField txtTipo;
        private JTextField txtDia;
        private JTextField txtMes;
        private JTextField txtAnio;
        private JTextField txtCiudad;
        private JTextField txtDepartamento;
        private JTextField txtPais;
        private JButton btnCancelar;
        private JButton btnRegistrar;
        private Coordinador miCoordinador;

        public RegistrarPersonasController(VentanaPrincipal ventanaPrincipal, boolean modal) {
            super(ventanaPrincipal, modal);
            this.setSize(624, 423);
            this.setLocationRelativeTo((Component)null);
            this.getContentPane().setLayout(new BorderLayout());
            this.iniciarComponentes();
            this.setTitle("Gestion de Personas");
        }

        private void iniciarComponentes() {
            this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.getContentPane().add(this.contentPanel, "Center");
            this.contentPanel.setLayout((LayoutManager)null);
            JLabel lblTitulo = new JLabel("GESTIONAR PERSONAS");
            lblTitulo.setHorizontalAlignment(0);
            lblTitulo.setFont(new Font("Tw Cen MT", 1, 20));
            lblTitulo.setBounds(10, 10, 599, 28);
            this.contentPanel.add(lblTitulo);
            JPanel panel = new JPanel();
            panel.setBorder(new BevelBorder(0, (Color)null, (Color)null, (Color)null, (Color)null));
            panel.setBounds(10, 49, 588, 324);
            this.contentPanel.add(panel);
            panel.setLayout((LayoutManager)null);
            JLabel lblNewLabel = new JLabel("Documento:");
            lblNewLabel.setBounds(24, 34, 71, 21);
            panel.add(lblNewLabel);
            this.txtDocumento = new JTextField();
            this.txtDocumento.setBounds(99, 34, 86, 20);
            panel.add(this.txtDocumento);
            this.txtDocumento.setColumns(10);
            JLabel lblNombre = new JLabel("Nombre:");
            lblNombre.setBounds(195, 34, 71, 21);
            panel.add(lblNombre);
            this.txtNombre = new JTextField();
            this.txtNombre.setColumns(10);
            this.txtNombre.setBounds(259, 34, 303, 20);
            panel.add(this.txtNombre);
            JLabel lblTelefono = new JLabel("Telefono:");
            lblTelefono.setBounds(24, 66, 71, 21);
            panel.add(lblTelefono);
            this.txtTelefono = new JTextField();
            this.txtTelefono.setColumns(10);
            this.txtTelefono.setBounds(99, 66, 86, 20);
            panel.add(this.txtTelefono);
            JLabel lblProfesion = new JLabel("Profesion:");
            lblProfesion.setBounds(195, 66, 71, 21);
            panel.add(lblProfesion);
            this.txtProfesion = new JTextField();
            this.txtProfesion.setColumns(10);
            this.txtProfesion.setBounds(259, 66, 167, 20);
            panel.add(this.txtProfesion);
            JLabel lblTipo = new JLabel("Tipo:");
            lblTipo.setBounds(439, 66, 71, 21);
            panel.add(lblTipo);
            this.txtTipo = new JTextField();
            this.txtTipo.setColumns(10);
            this.txtTipo.setBounds(476, 66, 86, 20);
            panel.add(this.txtTipo);
            JPanel panelNacimiento = new JPanel();
            panelNacimiento.setBorder(new TitledBorder((Border)null, "Datos de Nacimiento", 4, 2, (Font)null, (Color)null));
            panelNacimiento.setBounds(24, 122, 538, 109);
            panel.add(panelNacimiento);
            panelNacimiento.setLayout((LayoutManager)null);
            JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
            lblFecha.setBounds(10, 29, 122, 14);
            panelNacimiento.add(lblFecha);
            this.txtDia = new JTextField();
            this.txtDia.setBounds(142, 28, 25, 20);
            panelNacimiento.add(this.txtDia);
            this.txtDia.setColumns(10);
            this.txtMes = new JTextField();
            this.txtMes.setColumns(10);
            this.txtMes.setBounds(190, 28, 25, 20);
            panelNacimiento.add(this.txtMes);
            this.txtAnio = new JTextField();
            this.txtAnio.setColumns(10);
            this.txtAnio.setBounds(238, 28, 54, 20);
            panelNacimiento.add(this.txtAnio);
            JLabel lblNewLabel_1 = new JLabel("/");
            lblNewLabel_1.setBounds(177, 31, 38, 14);
            panelNacimiento.add(lblNewLabel_1);
            JLabel lblNewLabel_1_1 = new JLabel("/");
            lblNewLabel_1_1.setBounds(224, 31, 38, 14);
            panelNacimiento.add(lblNewLabel_1_1);
            JLabel lblCiudad = new JLabel("Ciudad:");
            lblCiudad.setBounds(10, 59, 71, 21);
            panelNacimiento.add(lblCiudad);
            this.txtCiudad = new JTextField();
            this.txtCiudad.setColumns(10);
            this.txtCiudad.setBounds(74, 59, 86, 20);
            panelNacimiento.add(this.txtCiudad);
            JLabel lblDepartamento = new JLabel("Departamento:");
            lblDepartamento.setBounds(185, 59, 92, 21);
            panelNacimiento.add(lblDepartamento);
            this.txtDepartamento = new JTextField();
            this.txtDepartamento.setColumns(10);
            this.txtDepartamento.setBounds(281, 59, 86, 20);
            panelNacimiento.add(this.txtDepartamento);
            JLabel lblPais = new JLabel("Pais:");
            lblPais.setBounds(385, 59, 54, 21);
            panelNacimiento.add(lblPais);
            this.txtPais = new JTextField();
            this.txtPais.setColumns(10);
            this.txtPais.setBounds(424, 59, 86, 20);
            panelNacimiento.add(this.txtPais);
            JSeparator separator = new JSeparator();
            separator.setBounds(24, 253, 538, 12);
            panel.add(separator);
            this.btnCancelar = new JButton("Cancelar");
            this.btnCancelar.setBounds(463, 276, 89, 23);
            this.btnCancelar.addActionListener(this);
            panel.add(this.btnCancelar);
            this.btnRegistrar = new JButton("Registrar");
            this.btnRegistrar.setBounds(364, 276, 89, 23);
            this.btnRegistrar.addActionListener(this);
            panel.add(this.btnRegistrar);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.btnRegistrar) {
                if (!this.txtDocumento.getText().equals("") && !this.txtNombre.getText().equals("") && !this.txtProfesion.getText().equals("") && !this.txtTelefono.getText().equals("") && !this.txtTipo.getText().equals("") && !this.txtCiudad.getText().equals("") && !this.txtDepartamento.getText().equals("") && !this.txtPais.getText().equals("") && !this.txtAnio.getText().equals("") && !this.txtMes.getText().equals("") && !this.txtDia.getText().equals("")) {
                    PersonaVo miPersona = new PersonaVo();
                    PersonaVo resp = this.miCoordinador.setConsultarPersona(Long.parseLong(this.txtDocumento.getText()));
                    if (resp == null) {
                        miPersona.setIdPersona(Long.parseLong(this.txtDocumento.getText()));
                        miPersona.setNombre(this.txtNombre.getText());
                        miPersona.setProfesion(this.txtProfesion.getText());
                        miPersona.setTelefono(this.txtTelefono.getText());
                        miPersona.setTipo(Integer.parseInt(this.txtTipo.getText()));
                        NacimientoVo miNacimiento = new NacimientoVo();
                        miNacimiento.setCiudadNacimiento(this.txtCiudad.getText());
                        miNacimiento.setDepartamentoNacimiento(this.txtDepartamento.getText());
                        miNacimiento.setPaisNacimiento(this.txtPais.getText());
                        miNacimiento.setFechaNacimiento(LocalDate.of(Integer.parseInt(this.txtAnio.getText()), Integer.parseInt(this.txtMes.getText()), Integer.parseInt(this.txtDia.getText())));
                        miPersona.setNacimiento(miNacimiento);
                        Long idNacimiento = this.miCoordinador.registrarNacimiento(miPersona);
                        if (idNacimiento != null) {
                            miPersona.getNacimiento().setIdNacimiento(idNacimiento);
                            String res = this.miCoordinador.registrarPersona(miPersona);
                            if (res.equals("ok")) {
                                JOptionPane.showMessageDialog((Component)null, "Registro Exitoso!");
                                this.limpiar();
                            } else {
                                JOptionPane.showMessageDialog((Component)null, res + ", verifique si el documento esta DUPLICADO", "ERROR", 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No se pudo registrar el Nacimiento", "ERROR", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "ADVERTENCIA: Lo sentimos, el documento esta DUPLICADO", "ERROR", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Por favor llene todos los campos", "Campos incompletos", 1);
                }
            } else if (e.getSource() == this.btnCancelar) {
                this.setVisible(false);
            }

        }

        private void limpiar() {
            this.txtDocumento.setText("");
            this.txtNombre.setText("");
            this.txtTelefono.setText("");
            this.txtProfesion.setText("");
            this.txtTipo.setText("");
            this.txtDia.setText("");
            this.txtMes.setText("");
            this.txtAnio.setText("");
            this.txtCiudad.setText("");
            this.txtDepartamento.setText("");
            this.txtPais.setText("");
        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }

