package com.app.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Question;
import com.app.pojos.Quize;
import com.app.service.QuestionService;
import com.app.service.QuizService;
import com.app.service.QuizeServiceImpl;

import antlr.collections.List;
import io.jsonwebtoken.lang.Collections;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	public QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	//update
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get question of any quize
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuetionsOfQuize(@PathVariable("qid") Long qid)
	{
//		Quize quize=new Quize();
//		quize.setQid(qid);
//		Set<Question>questionsOfQuize= this.questionService.getQuestionsOfQuiz(quize);
//		return ResponseEntity.ok(questionsOfQuize);
		
		Quize quize= this.quizService.getQuize(qid);
		Set<Question> questions= quize.getQuestions();
		java.util.List list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quize.getNumberOfQuestion()))
		{
			list=list.subList(0, Integer.parseInt(quize.getNumberOfQuestion()+1));
		}
		
		return ResponseEntity.ok(list);
	}
	
	//get single que
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId)
	{
		return this.questionService.getQuestion(quesId);
	}
	
	//delete
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId)
	{
		this.questionService.delete(quesId);
	}
}









