package com.example.demo.Modelo.Controller;

import com.example.demo.Controlador.Coordinador;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.example.demo.Modelo.vo.ProductoVo;

public class ConsultarProductosController extends JDialog implements ActionListener {

        private JPanel miPanel;
        private JTextArea AreaResultado;
        private JTextField textId;
        private Coordinador miCoordinador;
        private JButton btnEliminar;
        private JButton btnConsultar;
        private JButton btnCancelar;

        public ConsultarProductosController() {
            this.setBounds(100, 100, 474, 300);
            this.setLocationRelativeTo((Component)null);
            this.miPanel = new JPanel();
            this.miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            this.setContentPane(this.miPanel);
            this.miPanel.setLayout((LayoutManager)null);
            JLabel etiTitulo = new JLabel("Gestion Productos");
            etiTitulo.setFont(new Font("Tahoma", 1, 17));
            etiTitulo.setBounds(150, 11, 176, 20);
            this.miPanel.add(etiTitulo);
            this.AreaResultado = new JTextArea();
            this.AreaResultado.setLineWrap(true);
            JScrollPane scroll = new JScrollPane(this.AreaResultado, 22, 31);
            scroll.setBounds(25, 63, 423, 116);
            this.miPanel.add(scroll);
            JLabel etiId = new JLabel("Id:");
            etiId.setFont(new Font("Tahoma", 1, 14));
            etiId.setBounds(25, 214, 26, 20);
            this.miPanel.add(etiId);
            this.textId = new JTextField();
            this.textId.setBounds(61, 216, 86, 20);
            this.miPanel.add(this.textId);
            this.textId.setColumns(10);
            this.btnEliminar = new JButton("Eliminar");
            this.btnEliminar.setFont(new Font("Tahoma", 1, 11));
            this.btnEliminar.setBounds(155, 215, 93, 23);
            this.btnEliminar.addActionListener(this);
            this.miPanel.add(this.btnEliminar);
            this.btnConsultar = new JButton("Consultar");
            this.btnConsultar.setFont(new Font("Tahoma", 1, 11));
            this.btnConsultar.setBounds(258, 215, 100, 23);
            this.btnConsultar.addActionListener(this);
            this.miPanel.add(this.btnConsultar);
            this.btnCancelar = new JButton("Cancelar");
            this.btnCancelar.setFont(new Font("Tahoma", 1, 11));
            this.btnCancelar.setBounds(362, 215, 86, 23);
            this.btnCancelar.addActionListener(this);
            this.miPanel.add(this.btnCancelar);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.btnConsultar) {
                ArrayList<ProductoVo> productos = this.miCoordinador.consultarTodosLosProductos();
                this.AreaResultado.setText("" + productos);
            } else if (e.getSource() == this.btnEliminar) {
                if (this.textId.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Por favor llene el Campo de ID", "Campos incompletos", 1);
                } else {
                    long idLong = Long.parseLong(this.textId.getText());
                    String resul = this.miCoordinador.eliminarUnProductoConId(idLong);
                    if (resul.equals("ok")) {
                        JOptionPane.showMessageDialog((Component)null, "Eliminacion Exitosa!");
                        this.textId.setText("");
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "No se pudo Eliminar la Mascota", "ERROR", 0);
                    }
                }
            } else if (e.getSource() == this.btnCancelar) {
                this.setVisible(false);
            }

        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }

