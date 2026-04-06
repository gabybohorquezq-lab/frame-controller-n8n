package com.fybeca.frame_controller.repository.ge;

import com.fybeca.frame_controller.model.ge.ServidorAplicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServidorAplicacionRepository extends JpaRepository<ServidorAplicacion, Long> {

    List<ServidorAplicacion> findByActivo(Integer activo);
}
