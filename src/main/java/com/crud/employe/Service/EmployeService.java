package com.crud.employe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.employe.Entity.Employe;
import com.crud.employe.Repository.IEmpRep;

@Service
public class EmployeService {
	@Autowired
	private IEmpRep repo;
	
	public List<Employe> list(){
		return repo.findAll();
	}
	public void save(Employe emp) {
		repo.save(emp);
	}
	public Employe findById(Long id) {
		return repo.findById(id).get();
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
