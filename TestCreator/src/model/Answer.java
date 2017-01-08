package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="answer")
public class Answer  {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="answer_text")
	private String answerText;
	
	@Column(name="true_false")
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
