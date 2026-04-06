package com.fybeca.frame_controller.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servidores")
public class Servidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ip;
    private String usuario; // Ya corregido sin el $
    private String password;

    // Constructor vacío (obligatorio para JPA)
    public Servidor() {}

    // Getters y Setters (puedes generarlos con clic derecho -> Generate)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}