package com.app.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Question;
import com.app.pojos.Quize;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	Set<Question> findByQuize(Quize quize);

}
