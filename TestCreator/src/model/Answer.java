package model;



public class Answer  {

	private int id;
	private String answerText;
	private int trueFalse;
	
	public Answer()
	{
		
	}
	public Answer(String answerText,int trueFalse)
	{
		this.answerText = answerText;
		this.trueFalse = trueFalse;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public int getTrueFalse() {
		return trueFalse;
	}
	public void setTrueFalse(int trueFalse) {
		this.trueFalse = trueFalse;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	

}
