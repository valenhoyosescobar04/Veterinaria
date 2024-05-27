package com.example.demo.Modelo.Dao;

import com.example.demo.Modelo.vo.NacimientoVo;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class NacimientoDao {

        private static final String FILE_PATH = "nacimientos.dat";

        public NacimientoDao() {}

        public Long registrarNacimiento(NacimientoVo miNacimiento) throws IOException {
            Long idNacimiento = null;
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
                idNacimiento = System.currentTimeMillis(); // Generar un ID único basado en el tiempo
                miNacimiento.setIdNacimiento(idNacimiento);
                oos.writeObject(miNacimiento);
            } catch (IOException e) {
                System.out.println("No se pudo registrar los datos del nacimiento: " + e.getMessage());
                e.printStackTrace();
            }
            return idNacimiento;
        }

        public NacimientoVo consultarNacimiento(Long idNacimiento) throws IOException, ClassNotFoundException {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                while (true) {
                    try {
                        NacimientoVo miNacimiento = (NacimientoVo) ois.readObject();
                        if (miNacimiento.getIdNacimiento().equals(idNacimiento)) {
                            return miNacimiento;
                        }
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (FileNotFoundException e) {
                // Si el archivo no existe, retornamos null
            }
            return null;
        }

        public String actualizarNacimiento(NacimientoVo miNacimiento) throws IOException {
            Long idNacimiento = miNacimiento.getIdNacimiento();
            try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw")) {
                while (raf.getFilePointer() < raf.length()) {
                    long pos = raf.getFilePointer();
                    NacimientoVo nacimientoFromFile = (NacimientoVo) new ObjectInputStream(new ByteArrayInputStream(readNextObject(raf))).readObject();
                    if (nacimientoFromFile.getIdNacimiento().equals(idNacimiento)) {
                        raf.seek(pos);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(baos);
                        oos.writeObject(miNacimiento);
                        byte[] bytes = baos.toByteArray();
                        raf.write(bytes);
                        return "ok";
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se pudo actualizar los datos del nacimiento: " + e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        public String eliminarNacimiento(Long idNacimiento) throws IOException {
            try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw")) {
                while (raf.getFilePointer() < raf.length()) {
                    long pos = raf.getFilePointer();
                    NacimientoVo nacimientoFromFile = (NacimientoVo) new ObjectInputStream(new ByteArrayInputStream(readNextObject(raf))).readObject();
                    if (nacimientoFromFile.getIdNacimiento().equals(idNacimiento)) {
                        raf.seek(pos);
                        byte[] bytes = new byte[(int) (raf.length() - raf.getFilePointer())];
                        raf.readFully(bytes);
                        raf.setLength(pos);
                        raf.write(bytes);
                        return "ok";
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se pudo eliminar los datos del nacimiento: " + e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        private byte[] readNextObject(RandomAccessFile raf) throws IOException {
            int length = raf.readInt();
            byte[] bytes = new byte[length];
            raf.readFully(bytes);
            return bytes;
        }
    }

