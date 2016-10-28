package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import model.Question;
import model.Test;
import xmlpack.XMLXervices;

public class TestDao implements XMLOperations {

	private static Map<String, Test> allTests;
	
	public static void createTestsMap()
	
	{
		allTests = new LinkedHashMap<>();
	}

	public static void createTest(String testName, String creatorName, int numberOfQuestions)  {

		Test t = new Test(testName, creatorName, numberOfQuestions);
		if (allTests == null)
			createTestsMap();

		allTests.put(testName, t);
	}

	public static void addQuestonsToTest(List<Question> questionList, String testName) {
		allTests.get(testName).setListQuestions(questionList);

	}

	public static Map<String, Test> getToateTestele() {
		return  allTests;
	}

	private static Test getTestCurent(String testName) {
		Test temp = allTests.get(testName);
		return temp;
	}

	public static String getCreatorName(String creatorName) {

		return getTestCurent(creatorName).getCreatorName();
	}

	public static int getNumarIntrebari(String numeTest) {
		return getTestCurent(numeTest).getNumberOfQuestions();
	}

	public void deleteTest() {

	}

	public void editTest() {

	}


	public static void afis() {
		Set<String> keys = allTests.keySet();

		for (String k : keys) {
			Test t = allTests.get(k);
			System.out.println(k + "  key");
			System.out.println(t.getTestName());
			System.out.println(t.getId() + "  $$$$");
			System.out.println(t.getCreatorName());

			
		}

	}

	@Override
	public  void saveInXMLFile(String filePath) {
		String fileName = "Test.xml";

		File xmlFile = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\") + 1));
		System.out.println(xmlFile.getAbsolutePath());

		if (allTests == null)
			System.out.println(" toate teste null");
		else
			XMLXervices.saveAllTestsInXML(xmlFile, allTests);
		
	}

	@Override
	public  void loadFromXMLFile(String filePath) {
		allTests = XMLXervices.loadAllTestFromXML(filePath);
		
	}
}
