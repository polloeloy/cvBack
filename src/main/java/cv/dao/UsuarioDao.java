package cv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.entity.InformacionPersonal;
import cv.entity.Usuario;

public interface UsuarioDao extends JpaRepository <Usuario, Long> {

	Usuario findByEmail(String email);
    
	
}
