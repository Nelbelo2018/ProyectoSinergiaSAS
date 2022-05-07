package com.prueba.patient.DAO;

import com.prueba.patient.Models.Users.User;

public interface UserDAO {
    boolean verificarCredenciales(User user);
}
