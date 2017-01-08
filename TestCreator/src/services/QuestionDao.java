package services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import model.Question;
import model.Answer;

public class QuestionDao {
	
	private static List<Question> listaIntrebari;
	
	
	public static void createListaIntrebari()
	{
		listaIntrebari = new ArrayList<>();
	}
	
	public static void createIntrebare(String textIntrebare,int nrRaspunsuriCorecte,int nrRaspunsuri,List<Answer> listaRaspunsuri)
	{
		if(listaIntrebari==null) createListaIntrebari();
		
		Question i = new Question(textIntrebare, nrRaspunsuriCorecte, nrRaspunsuri, listaRaspunsuri);
		listaIntrebari.add(i);
		
	}
	
	public static List<Question> getListaIntrebari()
	{
		return listaIntrebari;
	}
	
	public static void editIntrebare()
	{
		
	}
	
	public static void deleteIntrebare()
	{
		
	}
	
	public static void showQuestion(Question i)
	{
		
		System.out.println("Text intrebare: "+i.getQuestionText());
	}
	
}
