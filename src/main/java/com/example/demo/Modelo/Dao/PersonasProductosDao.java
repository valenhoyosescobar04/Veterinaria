package com.example.demo.Modelo.Dao;
import com.example.demo.Controlador.Coordinador;
import com.example.demo.Modelo.vo.PersonaVo;
import com.example.demo.Modelo.vo.ProductoVo;

import java.io.*;

public class PersonasProductosDao {

    public class PersonaProductoDao {
        private static final String PERSONA_FILE_PATH = "personas.dat";
        private static final String PRODUCTO_FILE_PATH = "productos.dat";

        private Coordinador miCoordinador;

        public PersonaProductoDao() {}

        public PersonaVo obtenerIdPersona(int idPersona) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PERSONA_FILE_PATH))) {
                while (true) {
                    try {
                        PersonaVo persona = (PersonaVo) ois.readObject();
                        if (persona.getIdPersona() == idPersona) {
                            return persona;
                        }
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error en la consulta de la persona: " + e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        public ProductoVo obtenerIdProducto(int idProducto) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTO_FILE_PATH))) {
                while (true) {
                    try {
                        ProductoVo producto = (ProductoVo) ois.readObject();
                        if (producto.getIdProducto() == idProducto) {
                            return producto;
                        }
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error en la consulta del producto: " + e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }

}
