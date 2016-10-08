package services;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.Intrebare;
import model.Raspuns;

public class IntreabreService {
	
	private static ArrayList<Intrebare> listaIntrebari;
	
	
	public static void createListaIntrebari()
	{
		listaIntrebari = new ArrayList<>();
	}
	
	public static void createIntrebare(String textIntrebare,int nrRaspunsuriCorecte,int nrRaspunsuri,ArrayList<Raspuns> listaRaspunsuri)
	{
		if(listaIntrebari==null) createListaIntrebari();
		
		Intrebare i = new Intrebare(textIntrebare, nrRaspunsuriCorecte, nrRaspunsuri, listaRaspunsuri);
		listaIntrebari.add(i);
		
	}
	
	public static ArrayList<Intrebare> getListaIntrebari()
	{
		return listaIntrebari;
	}
	
	public static void editIntrebare()
	{
		
	}
	
	public static void deleteIntrebare()
	{
		
	}
	
	public static void afisIntrebari(Intrebare i)
	{
		
		System.out.println("Text intrebare: "+i.getTextIntrebare());
	}
	
}
