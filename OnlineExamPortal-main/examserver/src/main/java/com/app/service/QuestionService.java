package com.app.service;

import java.util.Set;

import com.app.pojos.Question;
import com.app.pojos.Quize;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question>getQuestions();
	public Question getQuestion(Long quesId);
	public Set<Question> getQuestionsOfQuiz(Quize quize);
	public void delete(Long QuesId);
}
