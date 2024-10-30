package com.More.PLN.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DenunciaDto {
    private int id;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String estado;
    private String ciudadano;
    private String telefonoCiudadano;
    private LocalDateTime fechaRegistro;
}
