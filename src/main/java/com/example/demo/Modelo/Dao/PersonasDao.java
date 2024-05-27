package com.example.demo.Modelo.Dao;
import com.example.demo.Modelo.vo.PersonaVo;

import java.io.*;
import java.util.ArrayList;
public class PersonasDao {
        private static final String FILE_PATH = "personas.dat";

        public void PersonaDao() {}

        public String registrarPersona(PersonaVo miPersona) {
            String resultado = "";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
                oos.writeObject(miPersona);
                resultado = "ok";
            } catch (IOException e) {
                System.out.println("No se pudo registrar la persona: " + e.getMessage());
                e.printStackTrace();
                resultado = "No se pudo registrar la persona";
            }
            return resultado;
        }

        public PersonaVo consultarPersona(Long idPersona) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                while (true) {
                    try {
                        PersonaVo persona = (PersonaVo) ois.readObject();
                        if (persona.getIdPersona().equals(idPersona)) {
                            return persona;
                        }
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al consultar la persona: " + e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        public String actualizarPersona(PersonaVo miPersona) {
            try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw")) {
                while (raf.getFilePointer() < raf.length()) {
                    long pos = raf.getFilePointer();
                    PersonaVo personaFromFile = (PersonaVo) new ObjectInputStream(new ByteArrayInputStream(readNextObject(raf))).readObject();
                    if (personaFromFile.getIdPersona().equals(miPersona.getIdPersona())) {
                        raf.seek(pos);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(baos);
                        oos.writeObject(miPersona);
                        byte[] bytes = baos.toByteArray();
                        raf.write(bytes);
                        return "ok";
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se pudo actualizar la persona: " + e.getMessage());
                e.printStackTrace();
            }
            return "No se pudo actualizar la persona";
        }

        public ArrayList<PersonaVo> consultarTodasLasPersonas() {
            ArrayList<PersonaVo> todasLasPersonas = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                while (true) {
                    try {
                        PersonaVo persona = (PersonaVo) ois.readObject();
                        todasLasPersonas.add(persona);
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al consultar todas las personas: " + e.getMessage());
                e.printStackTrace();
            }
            return todasLasPersonas;
        }

        public String eliminarPersona(long idPersona) {
            try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw")) {
                while (raf.getFilePointer() < raf.length()) {
                    long pos = raf.getFilePointer();
                    PersonaVo personaFromFile = (PersonaVo) new ObjectInputStream(new ByteArrayInputStream(readNextObject(raf))).readObject();
                    if (personaFromFile.getIdPersona().equals(idPersona)) {
                        raf.seek(pos);
                        byte[] bytes = new byte[(int) (raf.length() - raf.getFilePointer())];
                        raf.readFully(bytes);
                        raf.setLength(pos);
                        raf.write(bytes);
                        return "ok";
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se pudo eliminar la persona: " + e.getMessage());
                e.printStackTrace();
            }
            return "No se pudo eliminar la persona";
        }

        private byte[] readNextObject(RandomAccessFile raf) throws IOException {
            int length = raf.readInt();
            byte[] bytes = new byte[length];
            raf.readFully(bytes);
            return bytes;
        }
    }


