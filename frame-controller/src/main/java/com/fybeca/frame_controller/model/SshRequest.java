package com.fybeca.frame_controller.model;

public class SshRequest {

    // 1. Agregamos el ID para poder buscar en las tablas de Oracle
    private Long idFc;

    private String ip;
    private String usuario;
    private String password;
    private String rutaShell;
    private String servicio;

    // Getter y Setter del nuevo campo
    public Long getIdFc() { return idFc; }
    public void setIdFc(Long idFc) { this.idFc = idFc; }

    // Los demás se mantienen igual...
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRutaShell() { return rutaShell; }
    public void setRutaShell(String rutaShell) { this.rutaShell = rutaShell; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }
}