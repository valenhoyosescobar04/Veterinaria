package com.example.demo.Controlador;
import java.util.ArrayList;

import com.example.demo.Modelo.Dao.NacimientoDao;
import com.example.demo.Interfaces.MascotaVo;
import com.example.demo.Modelo.vo.NacimientoVo;
import com.example.demo.Modelo.vo.PersonaVo;
import com.example.demo.Modelo.vo.ProductoVo;
import com.example.demo.Modelo.Controller.ConsultarProductosController;
import com.example.demo.Modelo.Controller.RegistrarMascotasController;
import com.example.demo.Modelo.Controller.RegistrarPersonasController;
import com.example.demo.Modelo.Controller.RegistrarProductosController;
import com.example.demo.Modelo.Controller.TotalDePersonasRegistradas;
import com.example.demo.Modelo.Controller.VentanaPrincipal;

import com.example.demo.Modelo.Dao.*;
import com.example.demo.Modelo.Controller.*;

public class Coordinador {

    private VentanaPrincipal miVentanaPrincipal;
    private RegistrarPersonasController miRegistrarPersonasGui;
    private RegistrarMascotasController miRegistrarMascotasGui;
    private RegistrarProductosController miRegistrarProductosGui;
    private ConsultarPersonasController miConsultarPersonaGui;
    private ConsultarMascotaController miConsultarMascotasGui;
    private ConsultarProductosController miConsultarProductosGui;
    private TotalDePersonasRegistradas miTotalDePersonasRegistradas;

    private PersonasDao miPersonaDao;
    private MascotasDao miMascotaDao;
    private NacimientoDao miNacimientoDao;
    private ProductosDao miProductoDao;
    private PersonasProductosDao miPersonaProductoDao;

    public Coordinador() {
    }

    public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    public void setRegistrarPersonasGui(RegistrarPersonasController miRegistrarPersonasGui) {
        this.miRegistrarPersonasGui = miRegistrarPersonasGui;
    }

    public void setRegistrarMascotasGui(RegistrarMascotasController miRegistrarMascotasGui) {
        this.miRegistrarMascotasGui = miRegistrarMascotasGui;
    }

    public void setRegistrarProductosGui(RegistrarProductosController miRegistrarProductosGui) {
        this.miRegistrarProductosGui = miRegistrarProductosGui;
    }

    public void setPersonaDao(PersonasDao miPersonaDao) {
        this.miPersonaDao = miPersonaDao;
    }

    public void setMascotaDao(MascotasDao miMascotaDao) {
        this.miMascotaDao = miMascotaDao;
    }

    public void setNacimientoDao(NacimientoDao miNacimientoDao) {
        this.miNacimientoDao = miNacimientoDao;
    }

    public void setProductoDao(ProductosDao miProductoDao) {
        this.miProductoDao = miProductoDao;
    }

    public void setPersonaProductoDao(PersonasProductosDao miPersonaProductoDao) {
        this.miPersonaProductoDao = miPersonaProductoDao;
    }

    public void setConsultarPersonaGui(ConsultarPersonasController miConsultarPersonaGui) {
        this.miConsultarPersonaGui = miConsultarPersonaGui;
    }

    public void setConsultarMascotasGui(ConsultarMascotaController miConsultarMascotasGui) {
        this.miConsultarMascotasGui = miConsultarMascotasGui;
    }

    public void setConsultarProductosGui(ConsultarProductosController miConsultarProductosGui) {
        this.miConsultarProductosGui = miConsultarProductosGui;
    }

    public void setTotalDePersonasRegistradas(TotalDePersonasRegistradas miTotalDePersonasRegistradas) {
        this.miTotalDePersonasRegistradas = miTotalDePersonasRegistradas;
    }

    public void mostrarVentanaRegistroPersonas() {
        this.miRegistrarPersonasGui.setVisible(true);
    }

    public void mostrarVentanaRegistroMascotas() {
        this.miRegistrarMascotasGui.setVisible(true);
    }

    public void mostrarVentanaConsultaPersona() {
        this.miConsultarPersonaGui.setVisible(true);
    }

    public void mostrarVentanaConsultaMascotas() {
        this.miConsultarMascotasGui.setVisible(true);
    }

    public void mostrarVentanaConsultarProductos() {
        this.miConsultarProductosGui.setVisible(true);
    }

    public void mostrarVentanaTotalDePersonasRegistradas() {
        this.miTotalDePersonasRegistradas.setVisible(true);
    }

    public void mostrarVentanaRegistrarProductos() {
        this.miRegistrarProductosGui.setVisible(true);
    }

    public String registrarPersona(PersonaVo miPersona) {
        return this.miPersonaDao.registrarPersona(miPersona);
    }

    public Long registrarNacimiento(PersonaVo miPersona) {
        return this.miNacimientoDao.registrarNacimiento(miPersona.getNacimiento());
    }

    public PersonaVo consultarPersona(Long idDocumento) {
        return this.miPersonaDao.consultarPersona(idDocumento);
    }

    public NacimientoVo consultarNacimiento(long idNacimiento) {
        return this.miNacimientoDao.consultarNacimiento(idNacimiento);
    }

    public ArrayList<PersonaVo> consultarTodasLasPersonas() {
        return this.miPersonaDao.consultarTodasLasPersonas();
    }

    public String registrarMascota(MascotaVo miMascota) {
        return this.miMascotaDao.registrarMascota(miMascota);
    }

    public String actualizarPersona(PersonaVo miPersona) {
        return this.miPersonaDao.actualizarPersona(miPersona);
    }

    public String actualizarNacimiento(PersonaVo miPersona) {
        return this.miNacimientoDao.actualizarNacimiento(miPersona.getNacimiento());
    }

    public NacimientoVo obtenerIdNacimiento(int id) {
        return this.miNacimientoDao.obtenerIdNacimiento(id);
    }

    public String eliminarPersona(long idLong) {
        return this.miPersonaDao.eliminarPersona(idLong);
    }

    public String eliminarNacimiento(Long idUsuario) {
        return this.miNacimientoDao.eliminarNacimiento(idUsuario);
    }

    public String eliminarMascotaP(Long idPersona) {
        return this.miMascotaDao.eliminarMascotaP(idPersona);
    }

    public MascotaVo consultarMascota(Long idDocumento, String nombreMas) {
        return this.miMascotaDao.consultarMascota(idDocumento, nombreMas);
    }

    public String eliminarMascota(Long idDocumento, String nombre) {
        return this.miMascotaDao.eliminarMascota(idDocumento, nombre);
    }

    public String actualizarMascota(MascotaVo miMascota, long idLong, String nombre) {
        return this.miMascotaDao.actualizarMascota(miMascota, idLong, nombre);
    }

    public String registrarProducto(ProductoVo miProducto, int idUsuario) {
        return this.miProductoDao.registrarProductos(miProducto, idUsuario);
    }

    public String comprobarIdUsuario(int id) {
        return this.miProductoDao.comprobarIdUsuario(id);
    }

    public String eliminarProducto(Long idPersona) {
        return this.miProductoDao.eliminarProducto(idPersona);
    }

    public String eliminarTablaProductos(ArrayList<Long> lista) {
        return this.miProductoDao.eliminarTablaProductos(lista);
    }

    public ArrayList<Long> obtenerProductoId(int id) {
        return this.miProductoDao.obtenerProductoId(id);
    }

    public ArrayList<ProductoVo> consultarTodosLosProductos() {
        return this.miProductoDao.consultarTodosLosProductos();
    }

    public String eliminarUnProductoConId(Long idProducto) {
        return this.miProductoDao.eliminarProductoPorId(idProducto);
    }

    public void registrarVentanaRegistrarProductos() {
    }
}
