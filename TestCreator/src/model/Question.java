package model;


import java.util.List;

public class Question {

	private int id;
	private String questionText;
	private int numberOfCorrectAnswers;
	private int numberOfAnswers;

	private List<Answer> listAnswersi;
	
	public Question()
	{
		
	}
	

	public Question(String questionText, int numberOfCorrectAnswers, int numberOfAnswers, List<Answer> listAnswersi) {
		this.questionText = questionText;
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
		this.numberOfAnswers = numberOfAnswers;
		this.listAnswersi = listAnswersi;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}

	public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
	}

	public int getNumberOfAnswers() {
		return numberOfAnswers;
	}

	public void setNumberOfAnswers(int numberOfAnswers) {
		this.numberOfAnswers = numberOfAnswers;
	}

	public List<Answer> getListAnswersi() {
		return listAnswersi;
	}

	public void setListAnswersi(List<Answer> listAnswersi) {
		this.listAnswersi = listAnswersi;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
	
}
