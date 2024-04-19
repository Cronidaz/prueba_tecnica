package com.example.crud.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotNull(message = "El usuario no puede estar vacío")
    private String name;
    @Email(message = "Ponga un email correo")
    private String email;
    @NotNull(message = "La contraseña no puede estar vacío")
    private String password;
}
