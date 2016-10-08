package services;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.Intrebare;
import model.Test;
import xmlpack.XML;

public class TestServices {
	
	private static LinkedHashMap<String, Test> toateTestele;

	
	public static void createTest(String numeTest,String numeCreator,int nrIntrebari)
	{
		
		Test t = new Test(numeTest, numeCreator, nrIntrebari);
		if(toateTestele == null) toateTestele = getToateTestele();
		
		toateTestele.put(numeTest, t);
	}
	
	public static void addIntrebariLaTest(ArrayList<Intrebare> listaIntrebari,String numeTest)
	{
		toateTestele.get(numeTest).setListaIntrebari(listaIntrebari);
		
	}
	
	
	public static LinkedHashMap<String, Test> getToateTestele()
	{
		return new LinkedHashMap<>();
	}
	
	private static Test getTestCurent(String numeTest)
	{
		Test temp = toateTestele.get(numeTest);
		return temp;
	}
	
	
	public static String getNumeAutor(String numeTest)
	{
		
		return getTestCurent(numeTest).getNumeCreator();
	}
	
	public static int getNumarIntrebari(String numeTest)
	{
		return getTestCurent(numeTest).getNrIntrebari();
	}
	
	
	public void deleteTest()
	{
		
	}
	
	public void editTest()
	{
		
	}
	
	
	public static void salvezaTestInXml(String filePath)
	{
		String fileName="Test.xml";
		
		File xmlFile = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\") + 1));
		System.out.println(xmlFile.getAbsolutePath());
		
		XML.saveXMLToateTestele(xmlFile, toateTestele);
		
	}
}
