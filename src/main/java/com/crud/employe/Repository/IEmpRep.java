package com.crud.employe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.employe.Entity.Employe;

public interface IEmpRep extends JpaRepository<Employe, Long>{

}
