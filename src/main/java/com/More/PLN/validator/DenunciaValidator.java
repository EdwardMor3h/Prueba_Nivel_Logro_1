package com.More.PLN.validator;

import com.More.PLN.entity.Denuncia;
import com.More.PLN.exception.ValidateException;

public class DenunciaValidator {
    public static void save(Denuncia registro) {

        if (registro.getTitulo() == null || registro.getTitulo().trim().isEmpty()) {
            throw new ValidateException("El titulo es requerido");
        }
        if (registro.getDescripcion() == null || registro.getDescripcion().trim().isEmpty()) {
            throw new ValidateException("La descripcion no puede ser nula o vacia");
        }
        if (registro.getDescripcion().length() > 255) {
            throw new ValidateException("La Descripcion no debe exceder los 255 caracteres");
        }

        if (registro.getUbicacion().length() > 150) {
            throw new ValidateException("La Ubicacion no debe exceder los 150 caracteres");
        }

        if (registro.getEstado().length() > 20) {
            throw new ValidateException("El estado no debe exceder los 20 caracteres");
        }

        if (registro.getCiudadano().length() > 100) {
            throw new ValidateException("El ciudadano no debe exceder los 100 caracteres");
        }

        if (registro.getTelefonoCiudadano().length() > 15) {
            throw new ValidateException("El numero de telefono no debe exceder los 15 caracteres");
        }

        if (registro.getFechaRegistro() == null) {
            throw new ValidateException("La fecha de registro es requerida");
        }
    }
}
