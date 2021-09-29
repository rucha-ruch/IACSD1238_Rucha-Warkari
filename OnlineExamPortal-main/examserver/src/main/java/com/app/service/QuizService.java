package com.app.service;

import java.util.Set;

import com.app.pojos.Quize;

public interface QuizService {
	
		public Quize addQuize(Quize quize);
		public Quize UpdateQuize(Quize quize);
		public Set<Quize> getQuizes();
		public Quize getQuize(Long quizeId);
		public void deleteQuize(Long quizeId);
}
