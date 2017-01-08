package model;


import java.util.List;

public class Test {

	private int id;
	private String testName;
	private String creatorName;
	private int numberOfQuestions;
	private List<Question> listQuestions;
	
	public Test()
	{
		
	}
	public Test(String testName, String creatorName, int numberOfQuestions)
	{
		this.testName = testName;
		this.creatorName = creatorName;
		this.numberOfQuestions = numberOfQuestions;
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

}
