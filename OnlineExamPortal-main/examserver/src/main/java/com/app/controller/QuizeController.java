package com.app.controller;

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

import com.app.pojos.Quize;
import com.app.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizeController {
	
		@Autowired
		private QuizService quizService; 
		
		@PostMapping("/")
		public ResponseEntity<Quize>add(@RequestBody Quize quize)
		{
			return ResponseEntity.ok(this.quizService.addQuize(quize));
		}
		
		//update
		@PutMapping("/")
		public ResponseEntity<Quize> update(@RequestBody Quize quize)
		{
			return ResponseEntity.ok(this.quizService.UpdateQuize(quize));
		}
		
		//get quize
		@GetMapping("/")
		public ResponseEntity<?> getQuizes()
		{
			return ResponseEntity.ok(this.quizService.getQuizes());
		}
		
		//get singel quize
		@GetMapping("/{qid}")
		public Quize Quiz(@PathVariable("qid") Long qid)
		{
			return this.quizService.getQuize(qid);
		}
		
		//delete quize
		@DeleteMapping("/{qid}")
		public void delete (@PathVariable("qid") Long qid)
		{
			this.quizService.deleteQuize(qid);
		}
}
