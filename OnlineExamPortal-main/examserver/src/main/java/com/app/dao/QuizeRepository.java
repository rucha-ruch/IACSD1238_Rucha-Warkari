package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Quize;

public interface QuizeRepository  extends JpaRepository<Quize, Long>{

}
