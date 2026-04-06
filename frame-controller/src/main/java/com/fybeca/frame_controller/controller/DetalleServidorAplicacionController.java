package com.fybeca.frame_controller.controller;

import com.fybeca.frame_controller.model.ge.DetalleServidorAplicacion;
import com.fybeca.frame_controller.service.DetalleServidorAplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional; // <--- ESTO SOLUCIONA EL "Cannot resolve symbol Optional"

@RestController
@RequestMapping("/api/detalle-servidor")
public class DetalleServidorAplicacionController {

    @Autowired
    private DetalleServidorAplicacionService service;

    @PostMapping("/buscar")
    public ResponseEntity<DetalleServidorAplicacion> buscar(@RequestBody Map<String, Object> body) {
        Long idFc = Long.valueOf(body.get("idFc").toString());
        String servicio = body.get("servicio").toString();

        Optional<DetalleServidorAplicacion> detalle = service.buscarPorIdYServicio(idFc, servicio);

        // .map(ResponseEntity::ok) soluciona el error de "Incompatible types"
        return detalle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}