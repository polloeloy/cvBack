package cv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cv.dao.InformacionPersonalDao;
import cv.entity.InformacionPersonal;

@Service
@Qualifier("informacionService")
public class InformacionPersonalService  {
	@Autowired
	InformacionPersonalDao repository;
	
	 public Optional<InformacionPersonal> find(Long id) {
		 Optional<InformacionPersonal> informacionPersonal=Optional.ofNullable(new InformacionPersonal());
		 informacionPersonal= null;
		 informacionPersonal=repository.findById(id);
	        return informacionPersonal;
	    }
	 
	 public InformacionPersonal create(InformacionPersonal informacionPersonal) {
	        return repository.save(informacionPersonal);
	    }
}

