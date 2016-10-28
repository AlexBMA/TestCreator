package xmlpack;

import java.io.File;
import java.io.FileOutputStream;
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
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Question;
import model.Answer;
import model.Test;

public class XMLXervices {

	public static void saveAllTestsInXML(File xmlFile, Map<String, Test> allTests) {
		Document doc = new Document();
		Element theRoot = new Element("toate_testele");

		doc.setRootElement(theRoot);

		int size = allTests.size();
		theRoot.setAttribute("numar_teste", Integer.toString(size));

		Element teste = new Element("teste");

		Set<String> Keys = allTests.keySet();

		for (String i : Keys) {

			Test testTemp = allTests.get(i);
			Element t = saveXMLHelperTest(testTemp);
			teste.addContent(t);
		}
		theRoot.addContent(teste);

		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());

		try {
			xmlOutput.output(doc, new FileOutputStream(xmlFile));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void saveestInXML(File xmlFile, Test test) {
		Document doc = new Document();
		Element theRoot = new Element("test_simplu");
		doc.setRootElement(theRoot);

		Element t = saveXMLHelperTest(test);
		theRoot.addContent(t);

		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());

		try {
			xmlOutput.output(doc, new FileOutputStream(xmlFile));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Element saveXMLHelperTest(Test t) {
		Element test = new Element("test");

		Element idTest = new Element("id_test");
		idTest.addContent(t.getId() + "");

		Element numeTest = new Element("nume_test");
		numeTest.addContent(t.getTestName());

		Element autorTest = new Element("autor_test");
		autorTest.addContent(t.getCreatorName());

		Element nrIntrebari = new Element("numar_intrebari");
		nrIntrebari.addContent(t.getNumberOfQuestions() + "");

		Element intrebari = new Element("intrebari");

		List<Question> questionList = t.getListQuestions();
		int size = questionList.size();
		for (int j = 0; j < size; j++) {
			Question i = questionList.get(j);
			intrebari.addContent(saveXMLHelperIntrebari(i));
		}

		test.addContent(idTest);
		test.addContent(numeTest);
		test.addContent(autorTest);
		test.addContent(nrIntrebari);
		test.addContent(intrebari);

		System.out.println("Test was added \t");
		
		return test;

	}

	public static Element saveXMLHelperIntrebari(Question theQuestion) {
		Element question = new Element("intrebare");

		Element questionId = new Element("id_Intrebare");
		questionId.addContent(theQuestion.getId() + "");

		Element questionText = new Element("text_Intrebare");
		questionText.addContent(theQuestion.getQuestionText());

		Element numberOfCorrectAnswers = new Element("nr_Raspunsuri_Corecte");
		numberOfCorrectAnswers.addContent(theQuestion.getNumberOfCorrectAnswers() + "");

		Element numberOfAnswers = new Element("nr_Raspunsuri");
		numberOfAnswers.addContent(theQuestion.getNumberOfAnswers() + "");

		Element answer = new Element("raspunsuri");

		List<Answer> listaRaspunsuri = theQuestion.getListAnswersi();
		int size = listaRaspunsuri.size();

		for (int j = 0; j < size; j++) {
			Answer r = listaRaspunsuri.get(j);
			answer.addContent(saveXMLHelperRaspunsuri(r));
		}

		question.addContent(questionId);
		question.addContent(questionText);
		question.addContent(numberOfAnswers);
		question.addContent(numberOfCorrectAnswers);
		question.addContent(answer);

		return question;
	}

	public static Element saveXMLHelperRaspunsuri(Answer theAnswer) {
		Element answer = new Element("raspuns");

		Element idAnswer = new Element("id_Raspuns");
		idAnswer.addContent(theAnswer.getId() + "");

		Element answerText = new Element("text_Raspuns");
		answerText.addContent(theAnswer.getAnswerText());

		Element typeAnswer = new Element("tip_Raspuns");
		typeAnswer.addContent(theAnswer.getTrueFalse() + "");

		answer.addContent(idAnswer);
		answer.addContent(answerText);
		answer.addContent(typeAnswer);

		return answer;
	}

	public static Map<String, Test> loadAllTestFromXML(String filePath) {
		File fisier = new File(filePath);

		SAXBuilder builder = new SAXBuilder();

		Document readDoc;
		try {
			readDoc = builder.build(fisier);

			System.out.println("The root element: \t" + readDoc.getRootElement() + "\n");

			Element root = readDoc.getRootElement();

			System.out.println("Nr total de teste \t" + root.getAttributeValue("numar_teste") + "\n");

			Map<String, Test> allTests = new LinkedHashMap<>();

			Test testTemp;
			Element toateTesteElementXml = root.getChild("teste");
			for (Element currrentElem : toateTesteElementXml.getChildren()) {
				testTemp = loadTestFromXML(currrentElem);
				allTests.put(testTemp.getTestName(), testTemp);
			}

			return allTests;

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static Test loadTestFromXML(Element currrentTest) {
		
		String nameTest = currrentTest.getChildText("nume_test");
		String nameCreator = currrentTest.getChildText("autor_test");
		int numberOfQuestions = Integer.parseInt(currrentTest.getChildText("numar_intrebari"));
		int idTest = Integer.parseInt(currrentTest.getChildText("id_test"));

		Element listQuestionXMLElement = currrentTest.getChild("intrebari");

		List<Question> questionList = new ArrayList<>();
		Question tempQuestion;

		for (Element currentQuestion : listQuestionXMLElement.getChildren()) {
			tempQuestion = loadIQuestionFromXML(currentQuestion);
			questionList.add(tempQuestion);

		}
		Test testTemp = new Test(nameTest, nameCreator, numberOfQuestions);
		testTemp.setId(idTest);
		testTemp.setListQuestions(questionList);

		return testTemp;
	}

	public static Question loadIQuestionFromXML(Element currentQuestion) {
		String textQestion = currentQuestion.getChildText("text_Intrebare");
		int numberOfCorrectAnswers = Integer.parseInt(currentQuestion.getChildText("nr_Raspunsuri_Corecte"));
		int numberOfAnswers = Integer.parseInt(currentQuestion.getChildText("nr_Raspunsuri"));
		int idQuestion = Integer.parseInt(currentQuestion.getChildText("id_Intrebare"));

		List<Answer> listAnswers = new ArrayList<>();
		Answer tempAnswer;

		Element listAnswerXMLElement = currentQuestion.getChild("raspunsuri");

		for (Element answer : listAnswerXMLElement.getChildren()) {
			tempAnswer = loadAnswerFromXML(answer);
			listAnswers.add(tempAnswer);
		}

		Question question = new Question(textQestion, numberOfCorrectAnswers, numberOfAnswers, listAnswers);
		question.setId(idQuestion);

		return question;

	}

	public static Answer loadAnswerFromXML(Element currentAnswer) {
		String testAnswer = currentAnswer.getChildText("text_Intrebare");
		int trueFals = Integer.parseInt(currentAnswer.getChildText("tip_Raspuns"));
		int idAnswer = Integer.parseInt(currentAnswer.getChildText("id_Raspuns"));

		Answer answer = new Answer(testAnswer, trueFals);
		answer.setId(idAnswer);;

		return answer;

	}
}
