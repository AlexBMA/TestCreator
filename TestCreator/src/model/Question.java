package model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "question_text")
	private String questionText;
	@Column(name="number_of_correct_answers")
	private int numberOfCorrectAnswers;
	@Column(name="number_of_answers")
	private int numberOfAnswers;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(    name="question_answer", 
							joinColumns=@JoinColumn(name="answer_id"),
							inverseJoinColumns=@JoinColumn(name="question_id")
						)
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
