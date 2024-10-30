package com.More.PLN.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.More.PLN.entity.Denuncia;
import com.More.PLN.exception.GeneralException;
import com.More.PLN.exception.NoDataFoundException;
import com.More.PLN.exception.ValidateException;
import com.More.PLN.repository.DenunciaRepository;
import com.More.PLN.service.DenunciaService;
import com.More.PLN.validator.DenunciaValidator;

@Service
public class DenunciaServiceImpl implements DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Denuncia> findAll(Pageable page) {
        try {
            return repository.findAll(page).toList();
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    public List<Denuncia> findAll() {
        try {
            return repository.findAll();
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> findByNombre(String titulo, Pageable page) {
        try {
            return repository.findByTituloContaining(titulo, page);
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Denuncia findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
    }

    @Override
    @Transactional
    public Denuncia save(Denuncia denuncia) {
        // Validar los datos antes de guardarlos
        DenunciaValidator.save(denuncia);

        // Si el id es 0, se está creando una nueva denuncia
        if (denuncia.getId() == 0) {
            return repository.save(denuncia);
        }

        // Si el id existe, se actualiza la denuncia
        Denuncia registro = repository.findById(denuncia.getId())
                .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));

        // Actualizar los campos
        registro.setTitulo(denuncia.getTitulo());
        registro.setDescripcion(denuncia.getDescripcion());
        registro.setUbicacion(denuncia.getUbicacion());
        registro.setEstado(denuncia.getEstado());
        registro.setCiudadano(denuncia.getCiudadano());
        registro.setTelefonoCiudadano(denuncia.getTelefonoCiudadano());
        registro.setFechaRegistro(denuncia.getFechaRegistro());

        return repository.save(registro);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Denuncia registro = repository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
        repository.delete(registro);
    }
}
