package com.example.demo.Modelo.Dao;

import com.example.demo.Controlador.Coordinador;
import com.example.demo.Interfaces.MascotaVo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MascotasDao implements MascotaVo {

        private Coordinador miCoordinador;
        private static final String FILE_PATH = "mascotas.dat";

        public MascotasDao() {}

        public void setCoordinador(Coordinador miCoordinador) {
            this.miCoordinador = miCoordinador;
        }

        @Override
        public String registrarMascota(MascotaVo miMascota) throws IOException {
            List<MascotaVo> mascotas = consultarMascotas();
            mascotas.add(miMascota);
            guardarMascotas(mascotas);
            return "ok";
        }

        @Override
        public String eliminarMascotaP(Long idPersona) throws IOException {
            List<MascotaVo> mascotas = consultarMascotas();
            mascotas.removeIf(mascota -> mascota.getIdPersona().equals(idPersona));
            guardarMascotas(mascotas);
            return "ok";
        }

        @Override
        public MascotaVo consultarMascota(Long idMascota, String nombreMasc) throws IOException, ClassNotFoundException {
            List<MascotaVo> mascotas = consultarMascotas();
            for (MascotaVo mascota : mascotas) {
                if (mascota.getIdMascota().equals(idMascota) && mascota.getNombre().equals(nombreMasc)) {
                    return mascota;
                }
            }
            return null;
        }

        @Override
        public String eliminarMascota(long idMascota, String nombre) throws IOException {
            List<MascotaVo> mascotas = consultarMascotas();
            mascotas.removeIf(mascota -> mascota.getIdMascota() == idMascota && mascota.getNombre().equals(nombre));
            guardarMascotas(mascotas);
            return "ok";
        }

        @Override
        public String actualizarMascota(MascotaVo miMascota, long idMascota, String nombreMasc) throws IOException {
            eliminarMascota(idMascota, nombreMasc);
            registrarMascota(miMascota);
            return "ok";
        }

        @Override
        public List<MascotaVo> consultarMascotas() throws IOException, ClassNotFoundException {
            List<MascotaVo> mascotas = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                while (true) {
                    try {
                        MascotaVo mascota = (MascotaVo) ois.readObject();
                        mascotas.add(mascota);
                    } catch (EOFException e) {
                        break; // Fin del archivo alcanzado
                    }
                }
            } catch (FileNotFoundException e) {
                // Si el archivo no existe, retornamos una lista vacía
            }
            return mascotas;
        }

    @Override
    public Object getIdMascota() {
        return null;
    }

    @Override
    public Object getNombre() {
        return null;
    }

    @Override
    public Object getIdPersona() {
        return null;
    }

    private void guardarMascotas(List<MascotaVo> mascotas) throws IOException {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                for (MascotaVo mascota : mascotas) {
                    oos.writeObject(mascota);
                }
            }
        }
    }

