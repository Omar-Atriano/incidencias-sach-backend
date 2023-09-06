package com.sach.incidenciasbackend.Auth.Service;

import com.sach.incidenciasbackend.Auth.Request.LoginRequest;
import com.sach.incidenciasbackend.Auth.Request.RegisterRequest;
import com.sach.incidenciasbackend.Auth.Response.AuthResponse;
import com.sach.incidenciasbackend.Dao.UserRespository;
import com.sach.incidenciasbackend.Entity.User.Role;
import com.sach.incidenciasbackend.Entity.User.User;
import com.sach.incidenciasbackend.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRespository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .nombre(request.getNombre())
                .departamento(request.getDepartamento())
                .secretaria(request.getSecretaria())
                .direccion(request.getDireccion())
                .email(request.getEmail())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}