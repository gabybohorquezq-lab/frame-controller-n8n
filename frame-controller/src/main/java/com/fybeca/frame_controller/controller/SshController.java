package com.fybeca.frame_controller.controller;

import com.fybeca.frame_controller.model.SshRequest;
import com.fybeca.frame_controller.model.ge.DetalleServidorAplicacion;
import com.fybeca.frame_controller.model.ge.ServidorAplicacion;
import com.fybeca.frame_controller.service.DetalleServidorAplicacionService;
import com.fybeca.frame_controller.service.ServidorAplicacionService;
import com.fybeca.frame_controller.service.SshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ssh")
public class SshController {

    @Autowired
    private SshService sshService;

    @Autowired
    private DetalleServidorAplicacionService detalleService;

    @Autowired
    private ServidorAplicacionService servidorService;

    @PostMapping(value = "/ejecutar-con-bd", produces = "text/plain")
    public String ejecutarDesdeBd(@RequestBody SshRequest request) {
        try {
            // A. Obtener IP de Tabla 1
            ServidorAplicacion servidor = servidorService.buscarPorId(request.getIdFc());
            if (servidor == null) return "ERROR: Servidor no encontrado.";

            // Usamos el nombre exacto de tu entidad ServidorAplicacion
            String ipFinal = servidor.getIpServidor();

            // B. Obtener Detalle de Tabla 2 (Ruta y Credenciales)
            Optional<DetalleServidorAplicacion> detalleOpt = detalleService.buscarPorIdYServicio(
                    request.getIdFc(), request.getServicio());

            if (detalleOpt.isEmpty()) {
                return "ERROR: No hay configuración para el servicio " + request.getServicio();
            }

            DetalleServidorAplicacion data = detalleOpt.get();

            // C. Ejecutar en Linux
            String resultadoSsh = sshService.ejecutarScript(
                    ipFinal, data.getUsuarioFc(), data.getPasswordFc(),
                    data.getRutaShellFc(), request.getServicio());

            // D. Armar el Reporte Visual
            StringBuilder reporte = new StringBuilder();
            reporte.append("╔═══════════════════════════════════════════════════╗\n");
            reporte.append("║       REPORTE DE CONSULTA MULTI-TABLA (ORACLE)    ║\n");
            reporte.append("╠═══════════════════════════════════════════════════╣\n");
            reporte.append("  > ID BUSCADO      : ").append(request.getIdFc()).append("\n");
            reporte.append("  > IP (TABLA 1)    : ").append(ipFinal).append("\n");
            reporte.append("  > USUARIO (TABLA 2): ").append(data.getUsuarioFc()).append("\n");
            reporte.append("  > RUTA (TABLA 2)   : ").append(data.getRutaShellFc()).append("\n");
            reporte.append("  > SERVICIO        : ").append(request.getServicio()).append("\n");
            reporte.append("╠═══════════════════════════════════════════════════╣\n");
            reporte.append("║           RESULTADO DEL SERVIDOR LINUX            ║\n");
            reporte.append("╚═══════════════════════════════════════════════════╝\n\n");
            reporte.append(resultadoSsh);

            return reporte.toString();

        } catch (Exception e) {
            return "❌ ERROR: " + e.getMessage();
        }
    } // Llave que cierra el método ejecutarDesdeBd
} // Llave que cierra la clase SshController