package com.example.demo.Modelo.Controller;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.demo.Controlador.Coordinador;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.example.demo.Interfaces.MascotaVo;

public class ConsultarMascotaController extends JDialog implements ActionListener {

        private JPanel miPanel;
        private JTextField textDocumnto;
        private JTextField textNombre;
        private JTextField textRaza;
        private JTextField textSexo;
        private JTextField textColor;
        private JButton btnConsultar;
        private JButton btnEliminar;
        private JButton btnActualizar;
        private Coordinador miCoordinador;
        private JTextField textNombreId;

        public ConsultarMascotasGui() {
            this.setBounds(100, 100, 453, 314);
            this.setLocationRelativeTo((Component)null);
            this.miPanel = new JPanel();
            this.miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.setContentPane(this.miPanel);
            this.miPanel.setLayout((LayoutManager)null);
            this.btnConsultar = new JButton("Consultar");
            this.btnConsultar.setFont(new Font("Tahoma", 1, 12));
            this.btnConsultar.setBounds(247, 79, 107, 23);
            this.btnConsultar.addActionListener(this);
            this.miPanel.add(this.btnConsultar);
            JLabel etiIdDuenio = new JLabel("Id de Dueño");
            etiIdDuenio.setFont(new Font("Tahoma", 1, 12));
            etiIdDuenio.setBounds(22, 46, 89, 23);
            this.miPanel.add(etiIdDuenio);
            this.textDocumnto = new JTextField();
            this.textDocumnto.setBounds(132, 48, 100, 20);
            this.miPanel.add(this.textDocumnto);
            this.textDocumnto.setColumns(10);
            JLabel etiTitulo = new JLabel("Gestion de mascotas");
            etiTitulo.setFont(new Font("Tahoma", 1, 17));
            etiTitulo.setBounds(122, 11, 203, 23);
            this.miPanel.add(etiTitulo);
            JLabel etiNombre = new JLabel("Nombre:");
            etiNombre.setFont(new Font("Tahoma", 1, 14));
            etiNombre.setBounds(22, 133, 66, 28);
            this.miPanel.add(etiNombre);
            JLabel etiRaza = new JLabel("Raza:");
            etiRaza.setFont(new Font("Tahoma", 1, 14));
            etiRaza.setBounds(246, 136, 50, 22);
            this.miPanel.add(etiRaza);
            this.textNombre = new JTextField();
            this.textNombre.setBounds(122, 139, 100, 20);
            this.miPanel.add(this.textNombre);
            this.textNombre.setColumns(10);
            this.textRaza = new JTextField();
            this.textRaza.setBounds(306, 139, 117, 20);
            this.miPanel.add(this.textRaza);
            this.textRaza.setColumns(10);
            JLabel etiSexo = new JLabel("Sexo:");
            etiSexo.setFont(new Font("Tahoma", 1, 14));
            etiSexo.setBounds(22, 175, 59, 28);
            this.miPanel.add(etiSexo);
            this.textSexo = new JTextField();
            this.textSexo.setBounds(122, 181, 100, 20);
            this.miPanel.add(this.textSexo);
            this.textSexo.setColumns(10);
            JLabel etiColor = new JLabel("Color:");
            etiColor.setFont(new Font("Tahoma", 1, 14));
            etiColor.setBounds(246, 175, 50, 28);
            this.miPanel.add(etiColor);
            this.textColor = new JTextField();
            this.textColor.setBounds(306, 181, 117, 20);
            this.miPanel.add(this.textColor);
            this.textColor.setColumns(10);
            this.btnEliminar = new JButton("Eliminar");
            this.btnEliminar.setFont(new Font("Tahoma", 1, 11));
            this.btnEliminar.setBounds(325, 241, 90, 23);
            this.btnEliminar.addActionListener(this);
            this.miPanel.add(this.btnEliminar);
            this.btnActualizar = new JButton("Actualizar");
            this.btnActualizar.setFont(new Font("Tahoma", 1, 11));
            this.btnActualizar.setBounds(215, 241, 100, 23);
            this.btnActualizar.addActionListener(this);
            this.miPanel.add(this.btnActualizar);
            JLabel etiMascotaID = new JLabel("Nombre Mascota");
            etiMascotaID.setFont(new Font("Tahoma", 1, 12));
            etiMascotaID.setBounds(22, 80, 107, 23);
            this.miPanel.add(etiMascotaID);
            this.textNombreId = new JTextField();
            this.textNombreId.setColumns(10);
            this.textNombreId.setBounds(132, 79, 100, 20);
            this.miPanel.add(this.textNombreId);
        }

        public void actionPerformed(ActionEvent e) {
            String nombre;
            if (e.getSource() == this.btnConsultar) {
                if (!this.textDocumnto.getText().equals("") && !this.textNombreId.getText().equals("")) {
                    nombre = this.textNombreId.getText();
                    Long idDocumento = Long.parseLong(this.textDocumnto.getText());
                    MascotaVo mascota = this.miCoordinador.setConsultarMascotas(idDocumento, nombre);
                    if (mascota != null) {
                        this.textDocumnto.setText(this.textDocumnto.getText());
                        this.textNombre.setText(mascota.getNombre());
                        this.textColor.setText(mascota.getColorMascota());
                        this.textRaza.setText(mascota.getRaza());
                        this.textSexo.setText(mascota.getSexo());
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "No se encuentra la mascota, verifique el documento o nombre de la mascota", "ADVERTENCIA!!!", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Ingrese el campo de su documento y nombre de su mascota", "Incompleto", 2);
                }
            } else {
                long idLong;
                if (e.getSource() == this.btnActualizar) {
                    if (!this.textDocumnto.getText().equals("") && !this.textNombre.getText().equals("") && !this.textNombreId.getText().equals("") && !this.textColor.getText().equals("") && !this.textRaza.getText().equals("") && !this.textSexo.getText().equals("")) {
                        nombre = this.textNombreId.getText();
                        idLong = Long.parseLong(this.textDocumnto.getText());
                        MascotaVo miMascota = new MascotaVo();
                        miMascota.setNombre(this.textNombre.getText());
                        miMascota.setRaza(this.textRaza.getText());
                        miMascota.setColorMascota(this.textColor.getText());
                        miMascota.setSexo(this.textSexo.getText());
                        String resul = this.miCoordinador.actualizarMascota(miMascota, idLong, nombre);
                        if (resul.equals("ok")) {
                            JOptionPane.showMessageDialog((Component)null, "Actualización Exitosa!");
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No se pudo Actualizacion el Nacimiento", "ERROR", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Ingrese el campo de su documento y nombre de su mascota", "Campos incompletos", 1);
                    }
                } else if (e.getSource() == this.btnEliminar) {
                    if (!this.textDocumnto.getText().equals("") && !this.textNombre.getText().equals("") && !this.textNombreId.getText().equals("") && !this.textColor.getText().equals("") && !this.textRaza.getText().equals("") && !this.textSexo.getText().equals("")) {
                        nombre = this.textNombreId.getText();
                        idLong = Long.parseLong(this.textDocumnto.getText());
                        String resul = this.miCoordinador.eliminarMascota(idLong, nombre);
                        if (resul.equals("ok")) {
                            JOptionPane.showMessageDialog((Component)null, "Eliminacion Exitosa!");
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No se pudo Eliminar la Mascota", "ERROR", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Ingrese el campo de su documento y nombre de su mascota", "Campos incompletos", 1);
                    }
                }
            }

        }

        private void limpiar() {
            this.textDocumnto.setText("");
            this.textNombreId.setText("");
            this.textNombre.setText("");
            this.textRaza.setText("");
            this.textColor.setText("");
            this.textSexo.setText("");
        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }




