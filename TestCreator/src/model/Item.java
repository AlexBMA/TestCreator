package model;


import java.util.ArrayList;
import java.util.List;

public class Item {

	private String questionText;
	private List<String> myAnswers;
	private List<String> correctAnswers;
	
	
	public Item() {
		super();
		myAnswers = new ArrayList<>();
		correctAnswers = new ArrayList<>();
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
	public String  getAllCorectAnswerInAParagraf()
	{
		String answerParagraph=correctAnswers.get(0);
		int size = this.correctAnswers.size();
		for(int i=1;i<size;i++)
		{
			answerParagraph= answerParagraph+", "+ correctAnswers.get(i);
		}
		return answerParagraph;
	}
	
	public String getAllUserAnswersInAParagraf()
	{
		String answerParagraph=myAnswers.get(0);
		int size = this.myAnswers.size();
		for(int i=1;i<size;i++)
		{
			answerParagraph= answerParagraph+", "+ myAnswers.get(i);
		}
		return answerParagraph;
	}
	
	
}
