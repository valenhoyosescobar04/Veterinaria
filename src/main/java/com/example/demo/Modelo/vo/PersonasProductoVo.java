package com.example.demo.Modelo.vo;

public class PersonasProductoVo {
        private Long personaId;
        private Long productoId;

        public void PersonasProductosVo() {
        }

        public void PersonasProductosVo(Long personaId, Long productoId) {
            this.personaId = personaId;
            this.productoId = productoId;
        }

        public Long getPersonaId() {
            return this.personaId;
        }

        public void setPersonaId(Long personaId) {
            this.personaId = personaId;
        }

        public Long getProductoId() {
            return this.productoId;
        }

        public void setProductoId(Long productoId) {
            this.productoId = productoId;
        }

        public String toString() {
            return "PersonasProductosVo [personaId=" + this.personaId + ", productoId=" + this.productoId + "]";
        }
    }
