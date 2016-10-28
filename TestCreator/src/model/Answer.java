package model;



public class Answer extends TopEntity {

	
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
	
	
	
	

	

}
