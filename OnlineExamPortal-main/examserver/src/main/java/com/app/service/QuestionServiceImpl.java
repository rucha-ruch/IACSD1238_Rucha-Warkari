package com.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.QuestionRepository;
import com.app.pojos.Question;
import com.app.pojos.Quize;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesId) {
		
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quize quize) {
		
		return this.questionRepository.findByQuize(quize);
	}

	@Override
	public void delete(Long QuesId) {
		Question question=new Question();
		question.setQuesId(QuesId);
		this.questionRepository.delete(question);
		
	}

	
}
