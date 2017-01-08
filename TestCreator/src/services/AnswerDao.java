package services;

import java.util.ArrayList;
import java.util.List;

import model.Answer;

public class AnswerDao {

	private static List<Answer> listaRaspunsuri;
	
	public static void createListaRaspunsuri()
	{
		listaRaspunsuri = new ArrayList<>();
	}
	
	public static void createRaspuns(String textRaspuns,int advFals)
	{
		if(listaRaspunsuri == null) createListaRaspunsuri();
		Answer r = new Answer(textRaspuns, advFals);
		
		listaRaspunsuri.add(r);
	}
	
	public static List<Answer> getListaRaspunsuri()
	{
		return listaRaspunsuri;
	}
	
	public static void editRaspuns()
	{
		
	}
	
	public static void deleteRaspuns()
	{
		
	}
}
