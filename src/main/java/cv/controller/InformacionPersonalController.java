package cv.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Dto.InformacionPersonalDto;
import cv.entity.InformacionPersonal;
import cv.services.InformacionPersonalService;

@RestController
@RequestMapping("/informacion")
@CrossOrigin(origins= {"*"})
public class InformacionPersonalController {
	
		
		@Autowired
		InformacionPersonalService infServices;

		@GetMapping("/api/user/{id}")
	    public Optional<InformacionPersonal> byId(@PathVariable("id") long id) {
	        return infServices.find(id);
	    }
		
		@PostMapping
		public ResponseEntity<InformacionPersonal> create( @RequestBody InformacionPersonalDto informacionPersonalDto) throws IOException {
			byte[] archivoByte = Base64.getDecoder().decode(informacionPersonalDto.getFoto());
			InformacionPersonal informacionPersonal= new InformacionPersonal();
			informacionPersonal.setFoto(archivoByte);
			informacionPersonal.setApellido(informacionPersonalDto.getApellido());
			informacionPersonal.setNombre(informacionPersonalDto.getNombre());
			InformacionPersonal informacionPersonalCreated = infServices.create(informacionPersonal);
	        return new ResponseEntity(informacionPersonalCreated, HttpStatus.CREATED);
	    }
		
}
	    


