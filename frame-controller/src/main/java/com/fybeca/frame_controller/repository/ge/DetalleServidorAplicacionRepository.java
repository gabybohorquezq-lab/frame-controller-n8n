package com.fybeca.frame_controller.repository.ge;

import com.fybeca.frame_controller.model.ge.DetalleServidorAplicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DetalleServidorAplicacionRepository extends JpaRepository<DetalleServidorAplicacion, Long> {
    // Búsqueda precisa por ID de vínculo y nombre de servicio (status, stop, etc.)
    Optional<DetalleServidorAplicacion> findByIdFcAndServicio(Long idFc, String servicio);
}