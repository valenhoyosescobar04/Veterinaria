package com.example.demo.Modelo.Controller;

import com.example.demo.Controlador.Coordinador;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.example.demo.Modelo.vo.NacimientoVo;
import com.example.demo.Modelo.vo.PersonaVo;

public class ConsultarPersonasController extends JDialog implements ActionListener {

        private JPanel miPanel;
        private Coordinador miCoordinador;
        private JTextField textDocumento;
        private JTextField textNombre;
        private JTextField textTelefono;
        private JTextField textProfesion;
        private JTextField textTipo;
        private JTextField textDia;
        private JTextField textMes;
        private JTextField textAnio;
        private JTextField textCiudad;
        private JTextField textDepartamento;
        private JTextField textPais;
        private JLabel etiTitulo;
        private JLabel etiDocumento;
        private JLabel etiNombre;
        private JLabel etiTelefono;
        private JLabel etiProfesion;
        private JLabel etiTipo;
        private JLabel etiDatosNaci;
        private JLabel etiFecha;
        private JLabel etiCeparador;
        private JLabel etiCeparador_1;
        private JLabel etiCiudad;
        private JLabel etiDepartamento;
        private JLabel etiPais;
        private JButton btnCargar;
        private JButton btnCancelar;
        private JButton btnActualizar;
        private JButton btnEliminar;
        private NacimientoVo NacimientoVo;

        public ConsultarPersonasController() {
            this.iniciarComponentes();
        }

        private void iniciarComponentes() {
            this.miPanel = new JPanel();
            this.getContentPane().setBackground(Color.WHITE);
            this.getContentPane().setLayout((LayoutManager)null);
            this.setLocationRelativeTo((Component)null);
            this.setSize(600, 442);
            this.setResizable(false);
            this.setTitle("Clinica Veterinaria");
            this.setLocationRelativeTo((Component)null);
            this.etiTitulo = new JLabel("Gestion Personas");
            this.etiTitulo.setForeground(new Color(65, 105, 225));
            this.etiTitulo.setFont(new Font("Tahoma", 1, 17));
            this.etiTitulo.setBounds(195, 21, 176, 23);
            this.getContentPane().add(this.etiTitulo);
            this.etiDocumento = new JLabel("Documento");
            this.etiDocumento.setFont(new Font("Tahoma", 1, 14));
            this.etiDocumento.setBounds(239, 72, 87, 23);
            this.getContentPane().add(this.etiDocumento);
            this.textDocumento = new JTextField();
            this.textDocumento.setBounds(324, 75, 102, 20);
            this.textDocumento.setColumns(10);
            this.getContentPane().add(this.textDocumento);
            this.btnCargar = new JButton("Consultar");
            this.btnCargar.setBounds(436, 74, 102, 23);
            this.btnCargar.addActionListener(this);
            this.getContentPane().add(this.btnCargar);
            this.etiNombre = new JLabel("Nombre:");
            this.etiNombre.setFont(new Font("Tahoma", 1, 13));
            this.etiNombre.setBounds(27, 118, 58, 20);
            this.getContentPane().add(this.etiNombre);
            this.textNombre = new JTextField();
            this.textNombre.setBounds(95, 119, 464, 20);
            this.textNombre.setColumns(10);
            this.getContentPane().add(this.textNombre);
            this.etiTelefono = new JLabel("Telefono:");
            this.etiTelefono.setFont(new Font("Tahoma", 1, 13));
            this.etiTelefono.setBounds(27, 170, 65, 20);
            this.getContentPane().add(this.etiTelefono);
            this.etiProfesion = new JLabel("Profesion:");
            this.etiProfesion.setFont(new Font("Tahoma", 1, 13));
            this.etiProfesion.setBounds(206, 170, 68, 20);
            this.getContentPane().add(this.etiProfesion);
            this.etiTipo = new JLabel("Tipo:");
            this.etiTipo.setFont(new Font("Tahoma", 1, 13));
            this.etiTipo.setBounds(433, 170, 38, 20);
            this.getContentPane().add(this.etiTipo);
            this.textTelefono = new JTextField();
            this.textTelefono.setBounds(95, 171, 101, 20);
            this.textTelefono.setColumns(10);
            this.getContentPane().add(this.textTelefono);
            this.textProfesion = new JTextField();
            this.textProfesion.setBounds(284, 171, 139, 20);
            this.textProfesion.setColumns(10);
            this.getContentPane().add(this.textProfesion);
            this.textTipo = new JTextField();
            this.textTipo.setBounds(481, 171, 78, 20);
            this.textTipo.setColumns(10);
            this.getContentPane().add(this.textTipo);
            this.etiDatosNaci = new JLabel("Datos Nacimiento");
            this.etiDatosNaci.setForeground(new Color(65, 105, 225));
            this.etiDatosNaci.setFont(new Font("Tahoma", 1, 14));
            this.etiDatosNaci.setBounds(27, 217, 122, 23);
            this.getContentPane().add(this.etiDatosNaci);
            this.etiFecha = new JLabel("Fecha (dd/mm/aa):");
            this.etiFecha.setFont(new Font("Tahoma", 1, 12));
            this.etiFecha.setBounds(27, 251, 122, 21);
            this.getContentPane().add(this.etiFecha);
            this.textDia = new JTextField();
            this.textDia.setBounds(152, 251, 28, 20);
            this.textDia.setColumns(10);
            this.getContentPane().add(this.textDia);
            this.textMes = new JTextField();
            this.textMes.setColumns(10);
            this.textMes.setBounds(207, 252, 29, 20);
            this.getContentPane().add(this.textMes);
            this.textAnio = new JTextField();
            this.textAnio.setColumns(10);
            this.textAnio.setBounds(261, 252, 48, 20);
            this.getContentPane().add(this.textAnio);
            this.etiCeparador = new JLabel("/");
            this.etiCeparador.setFont(new Font("Tahoma", 1, 16));
            this.etiCeparador.setBounds(187, 249, 9, 23);
            this.getContentPane().add(this.etiCeparador);
            this.etiCeparador_1 = new JLabel("/");
            this.etiCeparador_1.setFont(new Font("Tahoma", 1, 16));
            this.etiCeparador_1.setBounds(246, 249, 9, 23);
            this.getContentPane().add(this.etiCeparador_1);
            this.etiCiudad = new JLabel("Ciudad:");
            this.etiCiudad.setFont(new Font("Tahoma", 1, 12));
            this.etiCiudad.setBounds(27, 296, 58, 20);
            this.getContentPane().add(this.etiCiudad);
            this.textCiudad = new JTextField();
            this.textCiudad.setBounds(95, 298, 101, 20);
            this.textCiudad.setColumns(10);
            this.getContentPane().add(this.textCiudad);
            this.etiDepartamento = new JLabel("Departamento:");
            this.etiDepartamento.setFont(new Font("Tahoma", 1, 12));
            this.etiDepartamento.setBounds(206, 296, 93, 20);
            this.getContentPane().add(this.etiDepartamento);
            this.textDepartamento = new JTextField();
            this.textDepartamento.setBounds(305, 297, 102, 20);
            this.textDepartamento.setColumns(10);
            this.getContentPane().add(this.textDepartamento);
            this.etiPais = new JLabel("Pais:");
            this.etiPais.setFont(new Font("Tahoma", 1, 12));
            this.etiPais.setBounds(417, 296, 38, 20);
            this.getContentPane().add(this.etiPais);
            this.textPais = new JTextField();
            this.textPais.setBounds(457, 297, 102, 20);
            this.textPais.setColumns(10);
            this.getContentPane().add(this.textPais);
            this.btnCancelar = new JButton("Cancelar");
            this.btnCancelar.setFont(new Font("Tahoma", 1, 13));
            this.btnCancelar.setBounds(457, 355, 102, 25);
            this.btnCancelar.addActionListener(this);
            this.getContentPane().add(this.btnCancelar);
            this.btnActualizar = new JButton("Actualizar");
            this.btnActualizar.setFont(new Font("Tahoma", 1, 14));
            this.btnActualizar.setBounds(224, 355, 102, 23);
            this.btnActualizar.addActionListener(this);
            this.getContentPane().add(this.btnActualizar);
            this.btnEliminar = new JButton("Eliminar");
            this.btnEliminar.setFont(new Font("Tahoma", 1, 14));
            this.btnEliminar.setBounds(350, 355, 95, 23);
            this.btnEliminar.addActionListener(this);
            this.getContentPane().add(this.btnEliminar);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.btnCargar) {
                if (this.textDocumento.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Ingrese el campo de su documento", "Campos incompletos", 1);
                } else {
                    Long idDocumento = Long.parseLong(this.textDocumento.getText());
                    PersonaVo p = this.miCoordinador.setConsultarPersona(idDocumento);
                    if (p != null) {
                        p.setNacimiento(this.miCoordinador.consultarNacimiento(p.getNacimiento().getIdNacimiento()));
                        this.textNombre.setText(p.getNombre());
                        this.textProfesion.setText(p.getProfesion());
                        this.textTelefono.setText(p.getTelefono());
                        this.textTipo.setText(String.valueOf(p.getTipo()));
                        this.textCiudad.setText(p.getNacimiento().getCiudadNacimiento());
                        this.textDepartamento.setText(p.getNacimiento().getDepartamentoNacimiento());
                        this.textPais.setText(p.getNacimiento().getPaisNacimiento());
                        this.textDia.setText(String.valueOf(p.getNacimiento().getFechaNacimiento().getDayOfMonth()));
                        this.textMes.setText(String.valueOf(p.getNacimiento().getFechaNacimiento().getMonthValue()));
                        this.textAnio.setText(String.valueOf(p.getNacimiento().getFechaNacimiento().getYear()));
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "No se encuentra la persona, verifique el documento", "ADVERTENCIA!!!", 2);
                    }
                }
            } else {
                int id;
                if (e.getSource() == this.btnActualizar) {
                    if (!this.textDocumento.getText().equals("") && !this.textNombre.getText().equals("") && !this.textTelefono.getText().equals("") && !this.textTipo.getText().equals("") && !this.textProfesion.getText().equals("") && !this.textDia.getText().equals("") && !this.textMes.getText().equals("") && !this.textAnio.getText().equals("") && !this.textCiudad.getText().equals("") && !this.textDepartamento.getText().equals("") && !this.textPais.getText().equals("")) {
                        id = Integer.parseInt(this.textDocumento.getText());
                        long idLong = Long.parseLong(this.textDocumento.getText());
                        NacimientoVo numeroID = this.miCoordinador.obtenerIdNacimiento(id);
                        Long idUsuario = numeroID.getIdNacimiento();
                        PersonaVo miPersona = new PersonaVo();
                        miPersona.setNombre(this.textNombre.getText());
                        miPersona.setProfesion(this.textProfesion.getText());
                        miPersona.setTelefono(this.textTelefono.getText());
                        miPersona.setTipo(Integer.parseInt(this.textTipo.getText()));
                        miPersona.setIdPersona(idLong);
                        NacimientoVo miNacimiento = new NacimientoVo();
                        miNacimiento.setCiudadNacimiento(this.textCiudad.getText());
                        miNacimiento.setDepartamentoNacimiento(this.textDepartamento.getText());
                        miNacimiento.setPaisNacimiento(this.textPais.getText());
                        miNacimiento.setIdNacimiento(idUsuario);
                        miNacimiento.setFechaNacimiento(LocalDate.of(Integer.parseInt(this.textAnio.getText()), Integer.parseInt(this.textMes.getText()), Integer.parseInt(this.textDia.getText())));
                        miPersona.setNacimiento(miNacimiento);
                        String idNacimiento = this.miCoordinador.actualizarNacimiento(miPersona);
                        this.miCoordinador.actualizarPersona(miPersona);
                        if (idNacimiento.equals("ok")) {
                            JOptionPane.showMessageDialog((Component)null, "Actualización Exitosa!");
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No se pudo Actualizacion el Nacimiento", "ERROR", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Debe tener los campos diligenciados y hacer la actualizacion que desee", "Campos incompletos", 1);
                    }
                } else if (e.getSource() == this.btnEliminar) {
                    if (this.textDocumento.getText().equals("")) {
                        JOptionPane.showMessageDialog((Component)null, "Debe de consultar la persona primero para poder eliminarla", "Campos incompletos", 1);
                    } else {
                        id = Integer.parseInt(this.textDocumento.getText());
                        ArrayList<Long> lista = this.miCoordinador.obtenerProductoId(id);
                        long idLong = Long.parseLong(this.textDocumento.getText());
                        NacimientoVo numeroID = this.miCoordinador.obtenerIdNacimiento(id);
                        Long idUsuario = numeroID.getIdNacimiento();
                        String eliMascota = this.miCoordinador.eliminarMascotaP(idLong);
                        this.miCoordinador.eliminarTablaProducto(lista);
                        String eliminarProd = this.miCoordinador.eliminarProducto(idLong);
                        this.miCoordinador.eliminarPersona(idLong);
                        String idNacimiento = this.miCoordinador.eliminarNacimiento(idUsuario);
                        if (idNacimiento.equals("ok")) {
                            JOptionPane.showMessageDialog((Component)null, "Eliminacion Exitosa!");
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No se pudo Eliminar el Nacimiento", "ERROR", 0);
                        }
                    }
                } else if (e.getSource() == this.btnCancelar) {
                    this.setVisible(false);
                }
            }

        }

        private void limpiar() {
            this.textDocumento.setText("");
            this.textNombre.setText("");
            this.textTelefono.setText("");
            this.textProfesion.setText("");
            this.textTipo.setText("");
            this.textDia.setText("");
            this.textAnio.setText("");
            this.textMes.setText("");
            this.textCiudad.setText("");
            this.textDepartamento.setText("");
            this.textPais.setText("");
        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }
