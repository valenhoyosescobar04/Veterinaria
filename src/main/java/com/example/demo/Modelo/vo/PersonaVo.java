package com.example.demo.Modelo.vo;

import com.example.demo.Interfaces.MascotaVo;

import java.util.ArrayList;
import java.util.List;

public class PersonaVo {

        private long idPersona;
        private String nombre;
        private String telefono;
        private String profesion;
        private int tipo;
        private NacimientoVo nacimiento;
        private List<MascotaVo> listaMascotas;

        public void PersonaVo() {
            this.listaMascotas = new ArrayList();
        }

        public void PersonaVo(long idPersona, String nombre, String telefono, String profesion, int tipo, NacimientoVo nacimiento) {
            this.idPersona = idPersona;
            this.nombre = nombre;
            this.telefono = telefono;
            this.profesion = profesion;
            this.tipo = tipo;
            this.nacimiento = nacimiento;
            this.listaMascotas = new ArrayList();
        }

        public long getIdPersona() {
            return this.idPersona;
        }

        public void setIdPersona(long idPersona) {
            this.idPersona = idPersona;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return this.telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getProfesion() {
            return this.profesion;
        }

        public void setProfesion(String profesion) {
            this.profesion = profesion;
        }

        public int getTipo() {
            return this.tipo;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public NacimientoVo getNacimiento() {
            return this.nacimiento;
        }

        public void setNacimiento(NacimientoVo nacimiento) {
            this.nacimiento = nacimiento;
        }

        public List<MascotaVo> getListaMascotas() {
            return this.listaMascotas;
        }

        public void setListaMascotas(List<MascotaVo> listaMascotas) {
            this.listaMascotas = listaMascotas;
        }

        public String toString() {
            return "idPersona: " + this.idPersona + "\nnombre: " + this.nombre + "\ntelefono: " + this.telefono + "\nprofesion: " + this.profesion + "\ntipo: " + this.tipo + "\nnacimiento: " + this.nacimiento + "\n\n";
        }
    }
