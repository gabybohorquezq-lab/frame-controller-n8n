package com.fybeca.frame_controller.model.ge;

import jakarta.persistence.*;

@Entity
@Table(name = "DETALLE_SERVIDOR_APLICACION")
public class DetalleServidorAplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE_PK")
    private Long idDetallePk;

    @Column(name = "ID_FC")
    private Long idFc;

    @Column(name = "USUARIO_FC")
    private String usuarioFc;

    @Column(name = "PASSWORD_FC")
    private String passwordFc;

    @Column(name = "RUTA_SHELL_FC")
    private String rutaShellFc;

    @Column(name = "SERVICIO")
    private String servicio;

    // Getters y Setters
    public Long getIdDetallePk() { return idDetallePk; }
    public void setIdDetallePk(Long idDetallePk) { this.idDetallePk = idDetallePk; }
    public Long getIdFc() { return idFc; }
    public void setIdFc(Long idFc) { this.idFc = idFc; }
    public String getUsuarioFc() { return usuarioFc; }
    public void setUsuarioFc(String usuarioFc) { this.usuarioFc = usuarioFc; }
    public String getPasswordFc() { return passwordFc; }
    public void setPasswordFc(String passwordFc) { this.passwordFc = passwordFc; }
    public String getRutaShellFc() { return rutaShellFc; }
    public void setRutaShellFc(String rutaShellFc) { this.rutaShellFc = rutaShellFc; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }
}