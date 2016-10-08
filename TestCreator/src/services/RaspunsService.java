package services;

import java.util.ArrayList;
import model.Raspuns;

public class RaspunsService {

	private static ArrayList<Raspuns> listaRaspunsuri;
	
	public static void createListaRaspunsuri()
	{
		listaRaspunsuri = new ArrayList<>();
	}
	
	public static void createRaspuns(String textRaspuns,int advFals)
	{
		if(listaRaspunsuri == null) createListaRaspunsuri();
		Raspuns r = new Raspuns(textRaspuns, advFals);
		
		listaRaspunsuri.add(r);
	}
	
	public static ArrayList<Raspuns> getListaRaspunsuri()
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
