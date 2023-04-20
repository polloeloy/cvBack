package cv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cv.dao.InformacionPersonalDao;
import cv.dao.UsuarioDao;
import cv.entity.InformacionPersonal;
import cv.entity.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
@Qualifier("usuarioService")
public class UsuarioServices {
	
	@Autowired
	UsuarioDao repository;
	
	 public Usuario create(Usuario usuario) {
	        return repository.save(usuario);
	    }
	 
	 public boolean verificarCredenciales(Usuario usuario) {
		
		 Usuario usuarioRecuperar=new Usuario();
		 usuarioRecuperar=repository.findByEmail(usuario.getEmail());
		 if (usuarioRecuperar==null) {
			 return false;
		 }
		 String passwordHashed= usuarioRecuperar.getPassword();
		 Argon2 argon2=Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i); 
		 boolean laPasswordEsLaMisma=argon2.verify(passwordHashed, usuario.getPassword());
		 
		 return laPasswordEsLaMisma;
		 
		 
	 }

}
