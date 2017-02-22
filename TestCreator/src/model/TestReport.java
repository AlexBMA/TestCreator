package model;

import java.util.List;

public class TestReport {

	List<Item> testItems;
	int score;

	public TestReport() {
		super();
	}

	public List<Item> getTestItems() {
		return testItems;
	}

	public void setTestItems(List<Item> testItems) {
		this.testItems = testItems;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
