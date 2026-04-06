package com.fybeca.frame_controller.service;

import com.fybeca.frame_controller.model.ge.ServidorAplicacion;
import com.fybeca.frame_controller.repository.ge.ServidorAplicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServidorAplicacionService {

    @Autowired
    private ServidorAplicacionRepository repository;

    @Transactional("geTransactionManager")
    public List<ServidorAplicacion> listarActivos() {
        return repository.findByActivo(1);
    }

    // --- NUEVO MÉTODO ---
    @Transactional("geTransactionManager")
    public ServidorAplicacion buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
