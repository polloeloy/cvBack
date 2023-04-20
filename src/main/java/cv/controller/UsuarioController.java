package cv.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Dto.MensajeErrorDto;
import cv.dao.UsuarioDao;
import cv.entity.InformacionPersonal;
import cv.entity.Usuario;
import cv.services.InformacionPersonalService;
import cv.services.UsuarioServices;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins= {"*"})

public class UsuarioController {

	@Autowired
    private UsuarioDao usuarioDao;
	
	@Autowired
	UsuarioServices usuarioServices;
	
	
	@PostMapping
	 public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
		    String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
		    usuario.setPassword(hash);
		    Usuario usuarioCreated=new Usuario();
		   
	          try {
	        	  usuarioCreated=usuarioDao.save(usuario);
	        	  return ResponseEntity.ok(usuarioCreated);
	          }catch
	           (DataIntegrityViolationException ex) {
	        	  MensajeErrorDto mensajeErrorDto= new MensajeErrorDto();
	        	  mensajeErrorDto.setMensaje("error de integridad");
	        	  return ResponseEntity.badRequest().body(mensajeErrorDto);  
	          }
	        	 // String response = "{\"status\":\"ok\"}";
	              
	              //return ResponseEntity.ok(response);
		   
	        
	
	
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
	    return ResponseEntity.badRequest().body("Error de integridad de datos: " + ex.getMessage());
	}
	
	@PostMapping("/api/user/login")
	public String login (@RequestBody Usuario usuario) {
		
		if(usuarioServices.verificarCredenciales(usuario)) {
			return "ok";
		}else {
			return "false";
		}
		
	        
	
	
	}
	
	
	
	
}

