package com.sach.incidenciasbackend.Dao;

import com.sach.incidenciasbackend.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String userName);
}
