package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "quize")
public class Quize {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long qid;
		private String title;
		private String description;
		private String maxMarks;
		
		private String numberOfQuestion;
		private boolean active=false;
		@ManyToOne(fetch = FetchType.EAGER)
		private Category category;
		@OneToMany(mappedBy = "quize",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JsonIgnore
		private Set<Question>questions=new HashSet<>();
		public Set<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(Set<Question> questions) {
			this.questions = questions;
		}

		public Quize() {
			
		}

		public Long getQid() {
			return qid;
		}

		public void setQid(Long qid) {
			this.qid = qid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getMaxMarks() {
			return maxMarks;
		}

		public void setMaxMarks(String maxMarks) {
			this.maxMarks = maxMarks;
		}
		
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}


		public String getNumberOfQuestion() {
			return numberOfQuestion;
		}

		public void setNumberOfQuestion(String numberOfQuestion) {
			this.numberOfQuestion = numberOfQuestion;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
}
