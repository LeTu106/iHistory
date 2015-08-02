package com.example.hackademics.ihistory.model;

import java.util.List;

public class Question {
	private String name;
	private String answer;
	private List<String> answers;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public Question(String name, String answer, List<String> answers) {
		this.name = name;
		this.answer = answer;
		this.answers = answers;
	}
	
	

}
