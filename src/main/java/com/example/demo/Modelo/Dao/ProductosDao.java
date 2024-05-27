package com.example.demo.Modelo.Dao;
import com.example.demo.Controlador.Coordinador;
import com.example.demo.Modelo.vo.ProductoVo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
public class ProductosDao {
        private Coordinador miCoordinador;

        public ProductosDao() {}

        public String registrarProductos(ProductoVo miProducto, int id) {
            String resultado = "";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.dat"));
                 ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("personas_productos.dat"))) {
                oos.writeObject(miProducto);
                oos2.writeInt(id);
                resultado = "ok";
            } catch (IOException e) {
                System.out.println("No se pudo registrar el Producto: " + e.getMessage());
                e.printStackTrace();
                resultado = "No se pudo registrar el Producto";
            }
            return resultado;
        }

        public String eliminarProducto(Long idPersona) {
            String resultado = "";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas_productos.dat"))) {
                oos.writeLong(idPersona);
                resultado = "ok";
            } catch (IOException e) {
                System.out.println("No se pudo eliminar el producto: " + e.getMessage());
                e.printStackTrace();
                resultado = "No se pudo eliminar el producto";
            }
            return resultado;
        }

        public ArrayList<Long> buscarIdProducto(int id) {
            ArrayList<Long> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas_productos.dat"))) {
                int storedId = ois.readInt();
                if (storedId == id) {
                    long productoId = ((ProductoVo) ois.readObject()).getIdProducto();
                    lista.add(productoId);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error en la consulta del producto: " + e.getMessage());
                e.printStackTrace();
            }
            return lista;
        }

        public String eliminarTablaProductos(ArrayList<Long> lista) {
            String resultado = "";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.dat"))) {
                for (Long idProducto : lista) {
                    oos.writeLong(idProducto);
                }
                resultado = "ok";
            } catch (IOException e) {
                System.out.println("No se pudo eliminar el producto: " + e.getMessage());
                e.printStackTrace();
                resultado = "No se pudo eliminar el producto";
            }
            return resultado;
        }

        public ArrayList<ProductoVo> consultarTodosLosProductos() {
            ArrayList<ProductoVo> todosLosDatos = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.dat"))) {
                while (true) {
                    try {
                        ProductoVo producto = (ProductoVo) ois.readObject();
                        todosLosDatos.add(producto);
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error en la consulta de los productos: " + e.getMessage());
                e.printStackTrace();
            }
            return todosLosDatos;
        }

        public String eliminarProductoPorId(Long idProducto) {
            String resultado = "";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.dat"))) {
                oos.writeLong(idProducto);
                resultado = "ok";
            } catch (IOException e) {
                System.out.println("No se pudo eliminar el producto: " + e.getMessage());
                e.printStackTrace();
                resultado = "No se pudo eliminar el producto";
            }
            return resultado;
        }

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }
    }


