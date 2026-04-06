package com.fybeca.frame_controller.controller;

import com.fybeca.frame_controller.model.ge.ServidorAplicacion;
import com.fybeca.frame_controller.service.ServidorAplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servidores-aplicacion")
public class ServidorAplicacionController {

    @Autowired
    private ServidorAplicacionService service;

    @PostMapping("/listar")
    public ResponseEntity<List<ServidorAplicacion>> listar() {
        return ResponseEntity.ok(service.listarActivos());
    }
}
