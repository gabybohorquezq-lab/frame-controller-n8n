package com.fybeca.frame_controller.model.ge;

import jakarta.persistence.*;

@Entity
@Table(name = "SERVIDOR_APLICACION")
public class ServidorAplicacion {

    @Id
    @Column(name = "ID_FC")
    private Long idFc;

    @Column(name = "IP_SERVIDOR")
    private String ipServidor;

    @Column(name = "NOMBRE_SERVIDOR")
    private String nombreServidor;

    @Column(name = "ACTIVO")
    private Integer activo;

    // --- GETTERS Y SETTERS ---

    public Long getIdFc() {
        return idFc;
    }

    public void setIdFc(Long idFc) {
        this.idFc = idFc;
    }

    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public String getNombreServidor() {
        return nombreServidor;
    }

    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
}