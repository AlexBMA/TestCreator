package model;


import java.util.List;

public class Item {

	private String questionText;
	private List<String> myAnswers;
	private List<String> correctAnswers;
	
	
	public Item() {
		super();
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<String> getMyAnswers() {
		return myAnswers;
	}
	public void setMyAnswers(List<String> myAnswers) {
		this.myAnswers = myAnswers;
	}
	public List<String> getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(List<String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
	
	
}
