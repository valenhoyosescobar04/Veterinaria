package com.example.demo.Interfaces;

import com.example.demo.Modelo.vo.MascotasVo;
import java.io.IOException;
import java.util.List;

public interface MascotaVo {

    String registrarMascota(MascotaVo miMascota) throws IOException;

    String eliminarMascotaP(Long idPersona) throws IOException;

    MascotaVo consultarMascota(Long idMascota, String nombreMasc) throws IOException, ClassNotFoundException;

    String eliminarMascota(long idMascota, String nombre) throws IOException;

    String actualizarMascota(MascotaVo miMascota, long idMascota, String nombreMasc) throws IOException;

    List<MascotaVo> consultarMascotas() throws IOException, ClassNotFoundException;

    Object getIdMascota();

    Object getNombre();

    Object getIdPersona();

    public interface MascotaDaoInterface {
        String registrarMascota(MascotaVo miMascota) throws IOException;
        String eliminarMascotaP(Long idPersona) throws IOException;
        MascotaVo consultarMascota(Long idMascota, String nombreMasc) throws IOException, ClassNotFoundException;
        String eliminarMascota(long idMascota, String nombre) throws IOException;
        String actualizarMascota(MascotaVo miMascota, long idMascota, String nombreMasc) throws IOException;
        List<MascotaVo> consultarMascotas() throws IOException, ClassNotFoundException;
    }

}
