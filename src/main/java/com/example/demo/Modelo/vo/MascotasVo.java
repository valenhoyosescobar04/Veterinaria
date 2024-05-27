package com.example.demo.Modelo.vo;

public class MascotasVo {
        private Long idMascota;
        private String nombre;
        private String raza;
        private String colorMascota;
        private String sexo;

        public void MascotaVo() {
        }

        public void MascotaVo(String nombre, String raza, String colorMascota, String sexo) {
            this.nombre = nombre;
            this.raza = raza;
            this.colorMascota = colorMascota;
            this.sexo = sexo;
        }

        public Long getIdMascota() {
            return this.idMascota;
        }

        public void setIdMascota(Long idMascota) {
            this.idMascota = idMascota;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getRaza() {
            return this.raza;
        }

        public void setRaza(String raza) {
            this.raza = raza;
        }

        public String getColorMascota() {
            return this.colorMascota;
        }

        public void setColorMascota(String colorMascota) {
            this.colorMascota = colorMascota;
        }

        public String getSexo() {
            return this.sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String toString() {
            return "MascotaVo [idMascota=" + this.idMascota + ", nombre=" + this.nombre + ", raza=" + this.raza + ", colorMascota=" + this.colorMascota + ", sexo=" + this.sexo + "]";
        }
    }
