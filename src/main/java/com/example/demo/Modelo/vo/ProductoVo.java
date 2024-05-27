package com.example.demo.Modelo.vo;

public class ProductoVo {
        private Long idProducto;
        private String nombreProducto;
        private Double precioProducto;

        public ProductoVo() {
        }

        public ProductoVo(Long idProducto, String nombreProducto, Double precioProducto) {
            this.idProducto = idProducto;
            this.nombreProducto = nombreProducto;
            this.precioProducto = precioProducto;
        }

        public Long getIdProducto() {
            return this.idProducto;
        }

        public void setIdProducto(long idProducto) {
            this.idProducto = idProducto;
        }

        public String getNombreProducto() {
            return this.nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        public Double getPrecioProducto() {
            return this.precioProducto;
        }

        public void setPrecioProducto(Double precioProducto) {
            this.precioProducto = precioProducto;
        }

        public String toString() {
            return "ID Producto: " + this.idProducto + "\nNombre Producto: " + this.nombreProducto + "\nPrecio Producto: " + this.precioProducto + "\n\n";
        }
    }
