package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="test")
public class Test {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name="test_name")
	private String testName;
	@Column(name="creator_name")
	private String creatorName;
	@Column(name="number_of_question")
	private int numberOfQuestions;
	
	@Column(name="user_id")
	private int userId;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(    name="test_question", 
							joinColumns=@JoinColumn(name="test_id"),
							inverseJoinColumns=@JoinColumn(name="question_id")
						)
	private List<Question> listQuestions;
	
	public Test()
	{
		
	}
	
	public Test(String testName,String creatorName)
	{
		this.testName = testName;
		this.creatorName = creatorName;
		this.listQuestions = new ArrayList<>();
	}
	
	public Test(String testName, String creatorName, int numberOfQuestions)
	{
		this.testName = testName;
		this.creatorName = creatorName;
		this.numberOfQuestions = numberOfQuestions;
		this.listQuestions = new ArrayList<>();
	}
	
	public Test(String testName, String creatorName, int numberOfQuestions, List<Question> listQuestions) {
		
		this.testName = testName;
		this.creatorName = creatorName;
		this.numberOfQuestions = numberOfQuestions;
		this.listQuestions = listQuestions;
	}
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public List<Question> getListQuestions() {
		return listQuestions;
	}
	public void setListQuestions(List<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
