package com.prueba.patient.DAO;

import com.prueba.patient.Models.Users.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Service
public class UserImplementDAO implements UserDAO{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public boolean verificarCredenciales(User user) {
        String query="FROM User WHERE documento = :documento AND contraseña = :contraseña";
        List<User>list=entityManager.createQuery(query)
                .setParameter("documento",user.getDocumento())
                .setParameter("contraseña",user.getContraseña())
                .getResultList();
        return !list.isEmpty();
    }
}
