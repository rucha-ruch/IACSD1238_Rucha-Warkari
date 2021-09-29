package com.app.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.QuizeRepository;
import com.app.pojos.Quize;

@Service
public class QuizeServiceImpl implements QuizService{

	@Autowired
	private QuizeRepository quizeRepository; 
	@Override
	public Quize addQuize(Quize quize) {
		
		return this.quizeRepository.save(quize);
	}

	@Override
	public Quize UpdateQuize(Quize quize) {
		
		return this.quizeRepository.save(quize);
	}

	@Override
	public Set<Quize> getQuizes() {
		
		return new HashSet<>(this.quizeRepository.findAll());
	}

	@Override
	public Quize getQuize(Long quizeId) {
		
		return this.quizeRepository.findById(quizeId).get();
	}

	@Override
	public void deleteQuize(Long quizeId) {
		Quize quize=new Quize();
		quize.setQid(quizeId);
		this.quizeRepository.delete(quize);
	}
	
}
