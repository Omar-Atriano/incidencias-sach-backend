package com.sach.incidenciasbackend.Auth.Request;

import com.sach.incidenciasbackend.Entity.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String nombre;
    String departamento;
    String secretaria;
    String direccion;
    String email;
    Role role;
}
