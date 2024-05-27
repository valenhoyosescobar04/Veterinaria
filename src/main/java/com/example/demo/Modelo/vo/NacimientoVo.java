package com.example.demo.Modelo.vo;

import java.time.LocalDate;
public class NacimientoVo {

    private long idNacimiento;
    private LocalDate fechaNacimiento;
    private String ciudadNacimiento;
    private String departamentoNacimiento;
    private String paisNacimiento;

    public NacimientoVo() {
    }

    public NacimientoVo(long idNacimiento, LocalDate fechaNacimiento, String ciudadNacimiento, String departamentoNacimiento, String paisNacimiento) {
        this.idNacimiento = idNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.departamentoNacimiento = departamentoNacimiento;
        this.paisNacimiento = paisNacimiento;
    }

    public long getIdNacimiento() {
        return this.idNacimiento;
    }

    public void setIdNacimiento(long idNacimiento) {
        this.idNacimiento = idNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudadNacimiento() {
        return this.ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getDepartamentoNacimiento() {
        return this.departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(String departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public String getPaisNacimiento() {
        return this.paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String toString() {
        String cad = "idNacimiento: " + this.idNacimiento + "\nfechaNacimiento: " + this.fechaNacimiento + "\nciudadNacimiento: " + this.ciudadNacimiento + "\ndepartamentoNacimiento :" + this.departamentoNacimiento + "\npaisNacimiento: " + this.paisNacimiento;
        return cad;
    }
}
