package cv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.entity.InformacionPersonal;

public interface InformacionPersonalDao extends JpaRepository <InformacionPersonal, Long> {
	
	

}
